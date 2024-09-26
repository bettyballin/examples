import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;

public class Temp239 {
    public static void main(String[] args) {
        try {
            String password = "yourPassword";
            String salt = "yourSalt";
            int iterations = 65536;
            int keyLength = 128;

            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), iterations, keyLength);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();

            // Print the resulting hash
            for (byte b : hash) {
                System.out.format("%02x", b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}