import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class Temp1454 {
    public static void main(String[] args) {
        char[] secret = "yourSecretPassword".toCharArray();
        int iterations = 65536;
        int keyLength = 256;
        byte[] salt = "someSalt".getBytes();

        PBEKeySpec keySpec = new PBEKeySpec(secret, salt, iterations, keyLength);

        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] key = keyFactory.generateSecret(keySpec).getEncoded();
            System.out.println(Base64.getEncoder().encodeToString(key));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}