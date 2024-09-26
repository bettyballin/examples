import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher2 {
    public static void main(String[] args) {
        try {
            String password = "YourPasswordHere";
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();
            // Further processing with the digest...
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}