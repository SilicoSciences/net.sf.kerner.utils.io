package net.sf.kerner.utils.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public abstract class AbstractGenericCollectionReader<T> implements GenericCollectionReader<T> {
	
	/**
	 * 
	 */
	public Collection<T> readAll(File file) throws IOException {
		return readAll(new FileInputStream(file));
	}

	/**
	 * 
	 */
	public Collection<T> readAll(InputStream stream) throws IOException {
		return readAll(IOUtils.inputStreamToReader(stream));
	}

}
