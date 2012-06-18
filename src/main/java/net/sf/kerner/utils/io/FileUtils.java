package net.sf.kerner.utils.io;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    private FileUtils() {
    }

/**
	 * Extended accessibility test, if a directory is available for reading. <br>
	 * it consists of following tests:
	 * <p>
	 * {@code dir.exists() && dir.canRead() && dir.isDirectory()
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
                return (dir.canRead() && dir.isDirectory());
            else {
                return dir.mkdirs();
            }
        } else {
            return (dir.exists() && dir.canRead() && dir.isDirectory());
        }
    }

    /**
     * <p>
     * Extended accessibility test, if a file is available for reading. <br>
     * it consists of following tests:
     * <ul>
     * <li>
	 * {@code file.exists()}</li>
     * <li>
	 * {@code file.canRead()}</li>
     * <li>
	 * {@code file.isFile()}</li>
     * </p>
     * 
     * @param file
     *            file, that is checked.
     * @param createIfAbsend
     *            if {@code !file.exists()}, it will be created.
     * @return true, if file is accessible; false otherwise.
     */
    public static boolean fileCheck(File file, boolean createIfAbsend) {
        if (createIfAbsend) {
            synchronized (file) {
                if (file.exists())
                    return (file.canRead() && file.isFile());
                else {
                    try {
                        return file.createNewFile();
                    } catch (Exception e) {
                        return false;
                    }
                }
            }
        } else {
            return (file.exists() && file.canRead() && file.isFile());
        }
    }

    public static boolean delete(File file) throws IOException {
        final boolean dirCheck = dirCheck(file, false);
        final boolean fileCheck = fileCheck(file, false);

        if (!dirCheck && !fileCheck)
            throw new IOException("cannot access [" + file + "]");

        if (dirCheck)
            return deleteDir(file);
        else
            return file.delete();
    }

    public static boolean deleteDir(File dir) throws IOException {
        final boolean dirCheck = dirCheck(dir, false);

        if (!dirCheck)
            throw new IOException("cannot access [" + dir + "]");

        final File[] files = dir.listFiles();
        for (File f : files) {
            if (!delete(f))
                return false;
        }

        return true;
    }

}
