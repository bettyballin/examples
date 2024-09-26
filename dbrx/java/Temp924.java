import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Temp924 {
    public static void main(String[] args) {
        String encryptedData = "your_encrypted_data_here";
        try {
            byte[] decrypt = Base64.getDecoder().decode(encryptedData);
            
            // Assuming the data is not actually encrypted but just encoded in Base64
            String decryptedMessage = new String(decrypt, StandardCharsets.UTF_8);
            
            System.out.println("Decrypted Message: " + decryptedMessage);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}