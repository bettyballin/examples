import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Main83 {
    public static void main(String[] args) {
        try {
            // Your secret key and ids
            String key = "very-secret-key";
            String id1 = "1001";
            String id2 = "2002";
            String id3 = "3003";

            // Create a HMAC SHA256 hash using the secret key
            Mac hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA256");
            hmac.init(secretKey);

            // Concatenate your ids and update the HMAC with the concatenated string
            hmac.update(id1.getBytes());
            hmac.update(id2.getBytes());
            hmac.update(id3.getBytes());

            // Get the digest in base64 and replace any '+' with '-' and '/' with '_'
            // to create a URL safe base64 encoded string
            String digest = Base64.getUrlEncoder().encodeToString(hmac.doFinal());

            System.out.println(digest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}