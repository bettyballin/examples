import java.io.*;
import java.security.*;

public class SignatureOutputStream extends FilterOutputStream {

    private Signature sig;

    public SignatureOutputStream(OutputStream target, Signature sig) {
        super(target);
        this.sig = sig;
    }

    @Override
    public void write(int b) throws IOException {
        try {
            sig.update((byte) b);
        } catch (SignatureException e) {
            throw new IOException(e);
        }
        out.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        try {
            sig.update(b, off, len);
        } catch (SignatureException e) {
            throw new IOException(e);
        }
        out.write(b, off, len);
    }
}