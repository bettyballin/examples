import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Temp3608 {
    public static void main(String[] args) {
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            char[] password = "password".toCharArray();
            byte[] salt = new byte[16];
            PBEKeySpec spec = new PBEKeySpec(password, salt, 65536, 128);
            secretKeyFactory.generateSecret(spec);

            System.out.println("SecretKeyFactory instance created successfully.");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}