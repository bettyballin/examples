import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyClass10 {

    public static byte[] MD5(byte[] data) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(data);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception
            return null;
        }
    }
}