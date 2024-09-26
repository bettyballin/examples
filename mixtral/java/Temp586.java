import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.SecretKey;

public class Temp586 {
    public static void main(String[] args) {
        try {
            char[] passphrase = "yourPassphrase".toCharArray();
            byte[] saltBytes = "yourSalt".getBytes();
            int iterationsCount = 65336;
            int keyLength = 256; // In bits

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            PBEKeySpec spec = new PBEKeySpec(passphrase, saltBytes, iterationsCount, keyLength);
            SecretKey secretKey = factory.generateSecret(spec);

            byte[] encodedKey = secretKey.getEncoded();

            // Print the generated key for demonstration purposes
            for (byte b : encodedKey) {
                System.out.printf("%02x", b);
            }
            System.out.println();

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}