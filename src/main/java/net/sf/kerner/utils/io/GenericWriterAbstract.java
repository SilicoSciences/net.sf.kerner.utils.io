package net.sf.kerner.utils.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class GenericWriterAbstract implements GenericWriter {

    public void write(final File file) throws IOException {
        write(new FileOutputStream(file));
    }

    public void write(final OutputStream stream) throws IOException {
        write(UtilIO.outputStreamToWriter(stream));
    }

}
