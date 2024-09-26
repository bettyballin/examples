import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;

public class Temp635 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            OutputStream os = System.out;
            writePrivateKey(privateKey, os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writePrivateKey(PrivateKey privateKey, OutputStream os) throws IOException {
        JcaPEMWriter pemWriter = new JcaPEMWriter(new PrintWriter(os));
        pemWriter.writeObject(privateKey);
        pemWriter.close();
    }
}