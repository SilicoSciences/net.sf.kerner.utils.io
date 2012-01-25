package net.sf.kerner.utils.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Collection;

public interface GenericCollectionReader<T> {
	
	public Collection<T> readAll(File file) throws IOException;
	
	public Collection<T> readAll(Reader reader) throws IOException;
	
	public Collection<T> readAll(InputStream stream) throws IOException;

}
