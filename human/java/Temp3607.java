import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Temp3607 {
    public static void main(String[] args) {
        try {
            char[] password = "password".toCharArray();
            byte[] salt = "saltsalt".getBytes();
            int iterations = 65536;
            int keyLength = 256;

            PBEKeySpec keySpec = new PBEKeySpec(password, salt, iterations, keyLength);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] encoded = secretKeyFactory.generateSecret(keySpec).getEncoded();

            // Print the encoded key
            for (byte b : encoded) {
                System.out.format("%02x", b);
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}