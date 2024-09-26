import org.apache.commons.codec.binary.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;

public class Temp1121 {
    public static void main(String[] args) {
        String originalString = "example";
        String hashedString = hashValue(originalString);
        System.out.println("Original: " + originalString);
        System.out.println("Hashed: " + hashedString);
    }

    public static String hashValue(String value) {
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(value.getBytes("UTF-16LE"));
            return new String(Base64.encodeBase64(hash));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}