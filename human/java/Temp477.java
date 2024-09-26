import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class Temp477 {
    public static void main(String[] args) {
        try {
            // Generate a key for the AES encryption
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256); // for example, 256-bit AES
            SecretKey secretKey = keyGen.generateKey();

            // Create the encryption key
            Key encryptionKey = new SecretKeySpec(secretKey.getEncoded(), "AES");

            // Print the key in a readable format
            System.out.println("Encryption Key: " + bytesToHex(encryptionKey.getEncoded()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to convert byte array to hex string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}