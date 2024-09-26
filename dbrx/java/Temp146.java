import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Temp146 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("c:\\public.key");
             FileOutputStream fos2 = new FileOutputStream("c:\\private.key")) {

            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair kp = keyGen.generateKeyPair();

            // Public key:
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(kp.getPublic().getEncoded());
            fos.write(x509EncodedKeySpec.getEncoded());

            // Private key:
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(kp.getPrivate().getEncoded());
            fos2.write(pkcs8EncodedKeySpec.getEncoded());
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }
}