/**
 * 
 *
 */
package net.sf.kerner.utils.io.buffered;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import net.sf.kerner.utils.io.IOUtils;

/**
 * 
 * An {@code AbstractBufferedReader} provides a {@link BufferedReader} instance
 * for buffered reading as well as convenient constructor methods to instantiate
 * this reader.
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-11-19
 * 
 */
public abstract class AbstractBufferedReader {

	/**
	 * {@link java.io.Reader} to which reading is delegated.
	 */
	protected BufferedReader reader;

	/**
	 * 
	 * 
	 * Create a new {@code AbstractBufferedReader} from a file.
	 * 
	 * @param file
	 *            file from which is read
	 * @throws IOException
	 * @see java.io.File
	 */
	public AbstractBufferedReader(File file) throws IOException {
		synchronized (AbstractBufferedReader.class) {
			this.reader = new BufferedReader(
					IOUtils.inputStreamToReader(new FileInputStream(file)));
		}
	}

	/**
	 * 
	 * 
	 * Create a new {@code AbstractBufferedReader} from a {@link java.io.Reader}
	 * .
	 * 
	 * @param reader
	 *            reader from which is read
	 * @see java.io.Reader
	 */
	public AbstractBufferedReader(Reader reader) {
		synchronized (AbstractBufferedReader.class) {
			this.reader = new BufferedReader(reader);
		}
	}

	/**
	 * 
	 * 
	 * Create a new {@code AbstractBufferedReader} from a
	 * {@link java.io.BufferedReader}.
	 * <p>
	 * <b>Note:</b> Passed in {@code java.io.BufferedReader} is kept as a
	 * reference. Use this constructor if you want to work on same
	 * {@link java.io.BufferedReader} which more than one reading-proxies.
	 * </p>
	 * 
	 * @param reader
	 *            buffered reader from which is read
	 * @see java.io.BufferedReader
	 */
	public AbstractBufferedReader(BufferedReader reader) {
		synchronized (AbstractBufferedReader.class) {
			this.reader = reader;
		}
	}

	/**
	 * 
	 * 
	 * Create a new {@code AbstractBufferedReader} from a
	 * {@link java.io.InputStream} .
	 * 
	 * @param stream
	 *            stream from which is read
	 * @see java.io.InputStream
	 */
	public AbstractBufferedReader(InputStream stream) {
		synchronized (AbstractBufferedReader.class) {
			this.reader = new BufferedReader(
					IOUtils.inputStreamToReader(stream));
		}
	}
	
	public void close() {
		IOUtils.closeProperly(reader);
	}
}
