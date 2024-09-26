import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class HashUtil {
    public static byte[] sha256digest16(String[] list) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        for(String s: list){
            digest.update(s.getBytes("UTF-8"));
        }

        byte[] b = digest.digest();
        return Arrays.copyOf(b, 16);
    }
}