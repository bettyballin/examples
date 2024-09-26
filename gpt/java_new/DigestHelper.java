import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestHelper {
    public static void main(String[] args) {
        try {
            MessageDigest sha1Digest = MessageDigest.getInstance("SHA-1");
            // Use the sha1Digest object for operations such as updating and digesting data
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}