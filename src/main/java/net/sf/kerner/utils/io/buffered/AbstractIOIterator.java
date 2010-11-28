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
 * <pre>
 * TODO example
 * </pre>
 * </p>
 *
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-11-22
 *
 * @param <E> type of elements which are iterated / read by this {@code AbstractIOIterator}
 */
public abstract class AbstractIOIterator<E> extends AbstractBufferedReader implements IOIterator<E> {
	
	/**
	 * Peek element.
	 */
	protected volatile E peek = null;

	/**
	 * Current index of this {@code AbstractIOIterator}.
	 */
	protected volatile long currentIndex = 0L;

	/**
	 * 
	 * TODO description
	 *
	 * @param reader
	 * @throws IOException
	 */
	public AbstractIOIterator(BufferedReader reader) throws IOException {
		super(reader);
		assign();
	}

	/**
	 * 
	 * TODO description
	 *
	 * @param file
	 * @throws IOException
	 */
	public AbstractIOIterator(File file) throws IOException {
		super(file);
		assign();
	}

	/**
	 * 
	 * TODO description
	 *
	 * @param stream
	 * @throws IOException
	 */
	public AbstractIOIterator(InputStream stream) throws IOException {
		super(stream);
		assign();
	}

	/**
	 * 
	 * TODO description
	 *
	 * @param reader
	 * @throws IOException
	 */
	public AbstractIOIterator(Reader reader) throws IOException {
		super(reader);
		assign();
	}
	
	private void assign() throws IOException{
		peek = doRead();
	}

	/**
	 * 
	 */
	public boolean hasNext() {
		return peek != null;
	}

	/**
	 * 
	 */
	public long nextIndex() {
		return currentIndex + 1;
	}
	
	/**
	 * 
	 */
	public synchronized E next() throws IOException {
		if (hasNext()) {
			final E result = peek;
			assign();
			return result;
		}
		throw new NoSuchElementException("no more elements");
	}
	
	/**
	 * 
	 * TODO description
	 *
	 * @return
	 * @throws IOException
	 */
	protected abstract E doRead() throws IOException;
	
}
