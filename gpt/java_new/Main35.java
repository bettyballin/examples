import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Main35 {
    public static void main(String[] args) {
        String value = "wattlebird";
        try {
            byte[] bytes = value.getBytes("UTF-16LE"); // Encode in UTF-16LE
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(bytes); // Compute MD5 hash
            String base64EncodedHash = Base64.getEncoder().encodeToString(hash); // Convert to Base64
            System.out.println(base64EncodedHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}