import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Temp3561 {
    public static void main(String[] args) throws Exception {
        // Sample data
        String id1 = "id1";
        String id2 = "id2";
        String id3 = "id3";
        byte[] buffer = "key".getBytes(StandardCharsets.UTF_8); // Example key
        
        // Create HMAC SHA-256
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(buffer, "HmacSHA256");
        mac.init(secretKeySpec);
        
        // Update with data
        mac.update(id1.getBytes(StandardCharsets.UTF_8));
        mac.update(id2.getBytes(StandardCharsets.UTF_8));
        mac.update(id3.getBytes(StandardCharsets.UTF_8));
        
        // Digest and encode to base64url
        byte[] digest = mac.doFinal();
        String token = Base64.getUrlEncoder().withoutPadding().encodeToString(digest);
        
        System.out.println(token);
    }
}