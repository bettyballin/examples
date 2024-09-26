import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Signature;
import java.security.SignatureException;

public class SignatureOutputStream extends FilterOutputStream {
    private final Signature signature;

    public SignatureOutputStream(OutputStream out, Signature signature) {
        super(out);
        this.signature = signature;
    }

    @Override
    public void write(int b) throws IOException {
        try {
            signature.update((byte) b);
        } catch (SignatureException e) {
            throw new IOException("Signature exception", e);
        }
        out.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        try {
            signature.update(b, off, len);
        } catch (SignatureException e) {
            throw new IOException("Signature exception", e);
        }
        out.write(b, off, len);
    }
}