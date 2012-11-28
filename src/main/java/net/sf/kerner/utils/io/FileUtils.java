package net.sf.kerner.utils.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileUtils {

    public static boolean delete(final File file) throws IOException {
        final boolean dirCheck = dirCheck(file, false);
        final boolean fileCheck = fileCheck(file, false);

        if (!dirCheck && !fileCheck)
            throw new IOException("cannot access [" + file + "]");

        if (dirCheck)
            return deleteDir(file);
        else
            return file.delete();
    }

    public static boolean deleteDir(final File dir) throws IOException {
        final boolean dirCheck = dirCheck(dir, false);

        if (!dirCheck)
            throw new IOException("cannot access [" + dir + "]");

        final File[] files = dir.listFiles();
        for (final File f : files) {
            if (!delete(f))
                return false;
        }

        return true;
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
    public static boolean dirCheck(final File dir, final boolean createIfAbsend) {
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
    public static boolean fileCheck(final File file, final boolean createIfAbsend) {
        if (createIfAbsend) {
            synchronized (file) {
                if (file.exists())
                    return (file.canRead() && file.isFile());
                else {
                    try {
                        boolean b = file.getParentFile().mkdirs();
                        b = file.createNewFile();
                        return b;
                    } catch (final Exception e) {
                        return false;
                    }
                }
            }
        } else {
            return (file.exists() && file.canRead() && file.isFile());
        }
    }

    public static List<File> getAllFilesInDir(final File dir, final boolean includeSubDirs) throws IOException {
        final List<File> result = new ArrayList<File>();
        new AbstractDirectoryWalker() {
            @Override
            public void handleDir(final File dir) throws IOException {
                if (includeSubDirs) {
                    result.addAll(getAllFilesInDir(dir, includeSubDirs));
                }
            }

            @Override
            public void handleFile(final File file) throws IOException {
                result.add(file);
            }
        }.walk(dir);
        Collections.sort(result);
        return result;
    }

    private FileUtils() {
    }

}
