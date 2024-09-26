import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Temp968 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            KeyPair keyPair = keyPairGenerator.genKeyPair();

            // extract the encoded private key, this is an unencrypted PKCS#8 private key
            byte[] encodedprivkey = keyPair.getPrivate().getEncoded();
            System.out.println(Base64.getEncoder().encodeToString(encodedprivkey));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}