package net.sf.kerner.utils.io.buffered;

import java.io.IOException;

public interface IOIterator<E> extends IOIteratorPrimitive {

	E next() throws IOException;
	
	E next(int bufferSize) throws IOException;

}
