/**
 * 
 *
 */
package net.sf.kerner.utils.io.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.NoSuchElementException;

import net.sf.kerner.utils.io.buffered.AbstractBufferedReader;
import net.sf.kerner.utils.io.buffered.IOIterator;

public abstract class AbstractIOIterator<E> extends AbstractBufferedReader implements IOIterator<E> {
	
	protected volatile E peek = null;

	protected volatile long currentIndex = 0L;

	public AbstractIOIterator(BufferedReader reader) throws IOException {
		super(reader);
		assign();
	}

	public AbstractIOIterator(File file) throws IOException {
		super(file);
		assign();
	}

	public AbstractIOIterator(InputStream stream) throws IOException {
		super(stream);
		assign();
	}

	public AbstractIOIterator(Reader reader) throws IOException {
		super(reader);
		assign();
	}
	
	private void assign() throws IOException{
		peek = doRead();
	}

	public boolean hasNext() {
		return peek != null;
	}

	public long nextIndex() {
		return currentIndex + 1;
	}
	
	public synchronized E next() throws IOException {
		if (hasNext()) {
			final E result = peek;
			assign();
			return result;
		}
		throw new NoSuchElementException("no more elements");
	}
	
	protected abstract E doRead() throws IOException;
	
}
