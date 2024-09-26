import java.io.*;

class LimitOutputStream extends FilterOutputStream {

    private long limit;

    public LimitOutputStream(OutputStream out, long limit) {
        super(out);
        if (limit < 0) 
            throw new IllegalArgumentException("Limit must be non-negative");
        this.limit = limit;
    }

    @Override
    public void write(int b) throws IOException {
        if (limit > 0) {
            out.write(b);
            limit--;
        }
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        if (limit <= 0 || len <= 0) 
            return;
        
        int toWrite = (int) Math.min(len, limit);
        out.write(b, off, toWrite);
        limit -= toWrite;
    }

    @Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }
}