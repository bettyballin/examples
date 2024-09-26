import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Temp82 {
    public static void main(String[] args) {
        try {
            String password = "yourPassword";
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            String encryptedPassword = Base64.getEncoder().encodeToString(md.digest());
            System.out.println("Encrypted Password: " + encryptedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}