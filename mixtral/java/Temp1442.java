import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp1442 {
    public static void main(String[] args) {
        String encodedKey = "YourBase64EncodedKeyHere"; // Replace with your actual Base64 encoded key
        byte[] encKey = Base64.getDecoder().decode(encodedKey);
        X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(encKey);
        
        // Additional code to use the pubKeySpec...
    }
}