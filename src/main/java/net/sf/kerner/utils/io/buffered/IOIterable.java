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

package net.sf.kerner.utils.io.buffered;

import java.io.IOException;

/**
 * An instance of {@code IOIterable} provides an [@link IOIterator} for reading elements in an iterator based manner.
 * <p>
 * <b>Example:</b><br>
 * </p>
 * <p>
 * 
 * <pre>
 * TODO example
 * </pre>
 * 
 * </p>
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2011-11-28
 * @param <E>
 *            type of elements which are iterated
 * @see java.lang.Iterable Iterable
 */
public interface IOIterable<E> {

    void close();

    /**
     * Retrieve the {@code IOIterator}.
     * 
     * @return the {@code IOIterator}
     * @throws IOException
     *             if anything goes wrong
     */
    IOIterator<E> getIterator() throws IOException;

}
