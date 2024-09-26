import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp2485 {
    public static void main(String[] args) {
        try {
            byte[] id1 = "1001".getBytes(StandardCharsets.UTF_8);
            byte[] id2 = "2002".getBytes(StandardCharsets.UTF_8);
            byte[] id3 = "3003".getBytes(StandardCharsets.UTF_8);

            // Concatenate the buffers
            byte[] combinedBuffer = new byte[id1.length + id2.length + id3.length];
            System.arraycopy(id1, 0, combinedBuffer, 0, id1.length);
            System.arraycopy(id2, 0, combinedBuffer, id1.length, id2.length);
            System.arraycopy(id3, 0, combinedBuffer, id1.length + id2.length, id3.length);

            // Create HMAC
            String secretKey = "very-secret-key";
            Mac hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            hmac.init(secretKeySpec);

            byte[] hmacBytes = hmac.doFinal(combinedBuffer);
            String token = Base64.getEncoder().encodeToString(hmacBytes).replace('.', ' ');

            System.out.println("Token: " + token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}