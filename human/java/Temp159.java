import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class SignatureExample {

    private static byte[] signData(OutputStream target, PrivateKey key, String[] data)
            throws IOException, GeneralSecurityException {
        Signature sig = Signature.getInstance("SHA1withRSA");
        sig.initSign(key);
        DataOutputStream dOut = new DataOutputStream(new SignatureOutputStream(target, sig));

        for (String s : data) {
            dOut.writeUTF(s);
        }
        byte[] signature = sig.sign();
        return signature;
    }

    private static void verify(PublicKey key, byte[] signature, byte[] data)
            throws IOException, GeneralSecurityException {
        Signature sig = Signature.getInstance("SHA1withRSA");
        sig.initVerify(key);

        ByteArrayOutputStream collector = new ByteArrayOutputStream(data.length);
        OutputStream checker = new SignatureOutputStream(collector, sig);
        checker.write(data);
        if (sig.verify(signature)) {
            System.err.println("Signature okay");
        } else {
            System.err.println("Signature falsed!");
        }
    }

    public static void main(String[] params) throws IOException, GeneralSecurityException {
        if (params.length < 1) {
            params = new String[] { "Hello", "World!" };
        }

        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        KeyPair pair = gen.generateKeyPair();

        ByteArrayOutputStream arrayStream = new ByteArrayOutputStream();

        byte[] signature = signData(arrayStream, pair.getPrivate(), params);
        byte[] data = arrayStream.toByteArray();

        verify(pair.getPublic(), signature, data);

        // change one byte by one
        data[3]++;

        verify(pair.getPublic(), signature, data);

        data = arrayStream.toByteArray();

        verify(pair.getPublic(), signature, data);

        // change signature
        signature[4]++;

        verify(pair.getPublic(), signature, data);
    }
}

class SignatureOutputStream extends OutputStream {
    private final OutputStream out;
    private final Signature sig;

    SignatureOutputStream(OutputStream out, Signature sig) {
        this.out = out;
        this.sig = sig;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
        try {
            sig.update((byte) b);
        } catch (GeneralSecurityException e) {
            throw new IOException("Signature update failed", e);
        }
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        out.write(b, off, len);
        try {
            sig.update(b, off, len);
        } catch (GeneralSecurityException e) {
            throw new IOException("Signature update failed", e);
        }
    }
}