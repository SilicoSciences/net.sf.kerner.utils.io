package net.sf.kerner.utils.io.buffered;

public interface IOIteratorPrimitive {

	boolean hasNext();

	long nextIndex();
	
	void close();

}
