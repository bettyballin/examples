import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Temp147 {
    public static void main(String[] args) {
        try {
            // Public key:
            FileInputStream fis = new FileInputStream("c:\\public.key");
            byte[] encodedPublicKey = new byte[fis.available()];
            fis.read(encodedPublicKey);
            fis.close();

            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedPublicKey);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            PublicKey publicK = kf.generatePublic(publicKeySpec);

            // Private key:
            FileInputStream fis2 = new FileInputStream("c:\\private.key");
            byte[] encodedPrivateKey = new byte[fis2.available()];
            fis2.read(encodedPrivateKey);
            fis2.close();

            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encodedPrivateKey);
            KeyFactory kf2 = KeyFactory.getInstance("RSA");
            PrivateKey privateK = kf2.generatePrivate(privateKeySpec);
            
            System.out.println("Public Key: " + publicK);
            System.out.println("Private Key: " + privateK);

        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}