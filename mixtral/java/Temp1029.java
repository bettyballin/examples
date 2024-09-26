import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Temp1029 {
    public static void main(String[] args) {
        String payload = "Hello World!";
        
        // create the JWT header
        String header = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
        
        // encode the header and payload
        String encodedHeader = Base64.getUrlEncoder().withoutPadding().encodeToString(header.getBytes());
        String encodedPayload = Base64.getUrlEncoder().withoutPadding().encodeToString(payload.getBytes());
        
        // create the signature
        String secret = "your-256-bit-secret";
        String signature = createSignature(encodedHeader + "." + encodedPayload, secret);
        
        // combine the header, payload, and signature into a JWT
        String jwt = encodedHeader + "." + encodedPayload + "." + signature;
        
        System.out.println(jwt);
    }
    
    private static String createSignature(String data, String secret) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            mac.init(secretKeySpec);
            byte[] rawHmac = mac.doFinal(data.getBytes());
            return Base64.getUrlEncoder().withoutPadding().encodeToString(rawHmac);
        } catch (Exception e) {
            throw new RuntimeException("Unable to create HMAC: " + e.getMessage());
        }
    }
}