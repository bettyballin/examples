import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Temp371 {
    public static void main(String[] args) {
        try {
            // Create a SecureRandom instance
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            
            // Define a seed value (for demonstration purposes, using a fixed seed)
            byte[] seed = {1, 2, 3, 4, 5};
            sr.setSeed(seed);
            
            // Create a KeyGenerator instance
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, sr); // 192 and 256 bits may not be available
            
            // Generate the secret key
            SecretKey skey = kgen.generateKey();
            
            // Print the generated key (encoded format)
            byte[] encodedKey = skey.getEncoded();
            System.out.println("Generated Key: " + bytesToHex(encodedKey));
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // Helper method to convert bytes to hex format for printing
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}