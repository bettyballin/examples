import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main17 {
    public static void main(String[] args) {
        try {
            String id = "YourIDHere";
            byte[] bytesOfMessage = id.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            // Further code to use the 'thedigest' as needed.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}