import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcEliecePublicKey;

public class PublicKeySerializer {

    public static void main(String[] args) {
        try {
            KeyPairGenerator keygen = KeyPairGenerator.getInstance("McEliece");
            PublicKey pub = keygen.generateKeyPair().getPublic();
            ByteArrayOutputStream baos = serializePublicKey(pub);
            // Use the serialized public key bytes from baos as needed
        } catch (NoSuchAlgorithmException e) {
            // Handle exception
        }
    }

    private static ByteArrayOutputStream serializePublicKey(PublicKey pub) {
        if (pub instanceof BCMcEliecePublicKey) {
            BCMcEliecePublicKey pubMcEliece = (BCMcEliecePublicKey) pub;
            int n = pubMcEliece.getN();
            int t = pubMcEliece.getT();
            byte[] g = pubMcEliece.getG().getEncoded();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ByteBuffer bb = ByteBuffer.allocate(4);
            bb.putInt(n);
            baos.write(bb.array(), 0, bb.position());
            bb.clear();
            bb.putInt(t);
            baos.write(bb.array(), 0, bb.position());
            try {
                baos.write(g);
            } catch (IOException e) {
                // Handle IOException
            }
            return baos;
        }
        return null;
    }
}