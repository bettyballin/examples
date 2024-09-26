import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp370 {
    public static void main(String[] args) {
        String base64EncodedString = "your_base64_encoded_string_here"; // Replace with your base64 encoded string
        byte[] encodedKey = Base64.getDecoder().decode(base64EncodedString);
        SecretKeySpec secretKeySpec = new SecretKeySpec(encodedKey, "AES");
        
        // additional code to use secretKeySpec if needed
    }
}