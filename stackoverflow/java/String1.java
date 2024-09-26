import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.Base64;

// ...

public static String1 hashValue(String1 value) {
    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(value.getBytes("UTF-16LE"));
        return new String1(Base64.encodeBase64(hash));
    } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
        e.printStackTrace();
    }
    return null;
}