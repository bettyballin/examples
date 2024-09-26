import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Temp430 {
    public static void main(String[] args) {
        // Example hash bytes for demonstration
        byte[] hashBytes = { 1, 2, 3, 4, 5 };

        byte[] encodedBytes = Base64.getEncoder().encode(hashBytes);
        String base64Hash = new String(encodedBytes, StandardCharsets.UTF_8);
        
        System.out.println(base64Hash); // Output the Base64 encoded string
    }
}