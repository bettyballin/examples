import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;

public class Main42 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            KeyPair keyPair = keyPairGenerator.genKeyPair();

            // extract the encoded private key, this is an unencrypted PKCS#8 private key
            byte[] encodedPrivateKey = keyPair.getPrivate().getEncoded();
            System.out.println(Base64.encodeBase64String(encodedPrivateKey));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}