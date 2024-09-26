import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;

public class Temp2211 {

    private static final String ENCRYPTION_KEY = "1234567890123456"; // Example key, must be 16 bytes for AES-128

    public static void main(String[] args) {
        Key key = makeKey();
        if (key != null) {
            System.out.println("Key generated successfully: " + key.toString());
        } else {
            System.out.println("Key generation failed.");
        }
    }

    static Key makeKey() {
        try {
            byte[] key = ENCRYPTION_KEY.getBytes("UTF-8");
            return new SecretKeySpec(key, "AES");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}