import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class Temp254 {
    public static void main(String[] args) {
        try {
            // Generate a key using the KeyGenerator class
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256); // Key size
            SecretKey secretKey = keyGen.generateKey();
            System.out.println("Generated Key: " + bytesToHex(secretKey.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // Utility method to convert byte array to hex string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}