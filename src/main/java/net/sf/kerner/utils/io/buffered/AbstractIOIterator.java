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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.NoSuchElementException;

/**
 * 
 * Prototype implementation for {@link IOIterator}.
 * 
 * <p>
 * <b>Example:</b><br>
 * 
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
 * @version 2010-12-01
 * 
 * @param <E>
 *            type of elements which are iterated / read by this
 *            {@code AbstractIOIterator}
 */
public abstract class AbstractIOIterator<E> extends AbstractBufferedReader
		implements IOIterator<E> {

	/**
	 * Peek element.
	 */
	protected volatile E peek = null;

	/**
	 * 
	 * Create a new {@code AbstractIOIterator} that reads from given
	 * {@link java.io.BufferedReader BufferedReader}.
	 * 
	 * @param reader
	 *            {@code BufferedReader} to read from
	 * @throws IOException 
	 * 
	 */
	public AbstractIOIterator(BufferedReader reader) throws IOException {
		super(reader);
	}

	/**
	 * 
	 * Create a new {@code AbstractIOIterator} that reads from given file.
	 * 
	 * @param file
	 *            file to read from
	 * @throws IOException 
	 * 
	 */
	public AbstractIOIterator(File file) throws IOException {
		super(file);
	}

	/**
	 * 
	 * Create a new {@code AbstractIOIterator} that reads from given
	 * {@link java.io.InputStream InputStream}.
	 * 
	 * @param stream
	 *            {@code InputStream} to read from
	 * @throws IOException
	 *             if reading fails
	 */
	public AbstractIOIterator(InputStream stream) throws IOException {
		super(stream);
	}

	/**
	 * 
	 * Create a new {@code AbstractIOIterator} that reads from given
	 * {@link java.io.Reader Reader}.
	 * 
	 * @param reader
	 *            reader to read from
	 * @throws IOException
	 *             if reading fails
	 */
	public AbstractIOIterator(Reader reader) throws IOException {
		super(reader);
	}

	/**
	 * @throws IOException 
	 * 
	 */
	public boolean hasNext() {
		
		return (peek != null);
	}

	/**
	 * 
	 */
	public synchronized E next() throws IOException {
		if (hasNext()) {
			final E result = peek;
			peek = doRead();
			return result;
		}
		throw new NoSuchElementException("no more elements");
	}

	/**
	 * 
	 * Perform the read operation.
	 * 
	 * @return the read element of type {@code E}
	 * @throws IOException
	 *             if reading fails
	 */
	protected abstract E doRead() throws IOException;

}
