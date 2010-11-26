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
package net.sf.kerner.utils.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * <p>
 * A {@code GenericReader} provides the ability to read something from
 * <ul>
 * <li>
 * a {@link File}</li>
 * <li>
 * a {@link Reader}</li>
 * <li>
 * an {@link InputStream}</li>
 * </ul>
 * </p>
 * <p>
 * TODO example
 * </p>
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-11-19
 * @see File
 * @see Reader
 * @see InputStream
 * 
 */
public interface GenericReader<T> {

	/**
	 * 
	 * Read something from a {@link File}.
	 * 
	 * 
	 * <p>
	 * TODO example
	 * </p>
	 * 
	 * @param file
	 *            file that is read
	 * @return something that is read from this file
	 * @throws IOException
	 */
	public T read(File file) throws IOException;

	/**
	 * 
	 * Read something from a {@link Reader}.
	 * 
	 * 
	 * <p>
	 * TODO example
	 * </p>
	 * 
	 * @param reader
	 *            {@link Reader} from which is read
	 * @return something that is read from this {@link Reader}
	 * @throws IOException
	 */
	public T read(Reader reader) throws IOException;

	/**
	 * 
	 * Read something from an {@link InputStream}.
	 * 
	 * 
	 * <p>
	 * TODO example
	 * </p>
	 * 
	 * @param stream
	 *            {@link InputStream} from which is read
	 * @return something that is read from this {@link InputStream}
	 * @throws IOException
	 */
	public T read(InputStream stream) throws IOException;

}
