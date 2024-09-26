import java.security.*;
import javax.crypto.*;

public class Temp2506 {
    public static void main(String[] args) {
        try {
            // Sample API key and public key (for demonstration purposes)
            String apiKey = "your_api_key_here";
            
            // Generate a public/private key pair for demonstration purposes
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair pair = keyGen.generateKeyPair();
            PublicKey publicKey = pair.getPublic();
            
            // Initialize the cipher with the public key for encryption
            Cipher ci = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            ci.init(Cipher.ENCRYPT_MODE, publicKey);
            
            // Encrypt the API key
            byte[] encryptedData = ci.doFinal(apiKey.getBytes());
            
            // Print the encrypted data as a hex string (for demonstration purposes)
            StringBuilder sb = new StringBuilder();
            for (byte b : encryptedData) {
                sb.append(String.format("%02x", b));
            }
            System.out.println("Encrypted Data: " + sb.toString());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}