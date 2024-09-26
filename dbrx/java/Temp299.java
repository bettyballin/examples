import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class Temp299 {
    public static void main(String[] args) {
        try {
            String key = "example_key"; // Replace with your key
            byte[] sha256Hash = MessageDigest.getInstance("SHA-256").digest(key.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec aesKey = new SecretKeySpec(sha256Hash, 0, 16, "AES");
            System.out.println("AES Key: " + java.util.Arrays.toString(aesKey.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}