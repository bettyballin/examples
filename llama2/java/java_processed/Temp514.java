import javax.crypto.SecretKeyFactory;
import java.security.NoSuchAlgorithmException;

public class Temp514 {
    public static void main(String[] args) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            System.out.println("SecretKeyFactory instance created successfully.");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}