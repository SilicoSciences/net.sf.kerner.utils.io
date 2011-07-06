package net.sf.kerner.utils.io;

import java.io.File;

public class FileUtils {
	
	private FileUtils(){}
	
	/**
	 * Extended accessibility test, if a directory is available for reading. <br>
	 * it consists of following tests:
	 * <p>
	 * {@code dir.exists() && dir.canRead() && dir.isDirectory() && dir.length()
	 * != 0}
	 * <p>
	 * 
	 * @param dir
	 *            directory, that is checked.
	 * @param createIfAbsend
	 *            if {@code !dir.exists()}, it will be created.
	 * @return true, if dir is accessible, false otherwise.
	 */
	public static boolean dirCheck(File dir, boolean createIfAbsend) {
		if (createIfAbsend) {
			if (dir.exists())
				return (dir.canRead() && dir.isDirectory() && dir.length() != 0);
			else {
				return dir.mkdirs();
			}
		} else {
			return (dir.exists() && dir.canRead() && dir.isDirectory() && dir
					.length() != 0);
		}
	}

}
