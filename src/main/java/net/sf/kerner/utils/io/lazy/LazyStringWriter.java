/**********************************************************************
Copyright (c) 2009-2010 Alexander Kerner. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 ***********************************************************************/

package net.sf.kerner.utils.io.lazy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.Writer;

import net.sf.kerner.utils.io.GenericWriter;
import net.sf.kerner.utils.io.IOUtils;
import net.sf.kerner.utils.io.buffered.impl.BufferedStringWriter;

/**
 * A {@code LazyStringWriter} provides the ability to write a string quickly to
 * <ul>
 * <li>a {@link java.io.File}</li>
 * <li>a {@link java.io.Writer}</li>
 * <li>an {@link java.io.OutputStream}</li>
 * </ul>
 * </p>
 * <p>
 * <b>Attention:</b> writing is not buffered! If you want to write large files, consider to use
 * {@link BufferedStringWriter} instead.
 * </p>
 * <p>
 * <b>Example:</b>
 * </p>
 * 
 * <pre>
 * &#064;Test
 * public final void example() throws IOException {
 *     final java.io.StringWriter wr = new java.io.StringWriter();
 *     new LazyStringWriter(&quot;Hallo Welt!&quot;).write(wr);
 *     assertEquals(&quot;Hallo Welt!&quot;, wr.toString());
 * }
 * </pre>
 * 
 * @author Alexander Kerner
 * @see java.io.File
 * @see java.io.Writer
 * @see java.io.OutputStream
 * @version 2010-09-10
 */
public class LazyStringWriter implements GenericWriter {

    private final String string;

    public LazyStringWriter(Object toString) {
        if (toString == null)
            throw new NullPointerException();
        this.string = toString.toString();
    }

    // Implement //

    public void write(File file) throws IOException {
        write(new FileWriter(file));
    }

    public void write(Writer writer) throws IOException {
        StringReader reader = null;
        try {
            reader = new StringReader(string);
            IOUtils.readerToWriter(reader, writer);
        } finally {
            IOUtils.closeProperly(writer);
            IOUtils.closeProperly(reader);
        }
    }

    public void write(OutputStream stream) throws IOException {
        write(IOUtils.outputStreamToWriter(stream));
    }
}
