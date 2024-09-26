import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class LimitedOutputStream extends FilterOutputStream {
    private final long maxBytes;
    private long writtenBytes = 0;

    public LimitedOutputStream(OutputStream out, long maxBytes) {
        super(out);
        this.maxBytes = maxBytes;
    }

    @Override
    public void write(int b) throws IOException {
        checkLimit(1);
        super.write(b);
        writtenBytes++;
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        checkLimit(len);
        super.write(b, off, len);
        writtenBytes += len;
    }

    private void checkLimit(long len) throws IOException {
        if (writtenBytes + len > maxBytes) {
            throw new IOException("Exceeded maximum number of bytes allowed");
        }
    }
}