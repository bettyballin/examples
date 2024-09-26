import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Temp1453 {
    private static final int SALT_LENGTH = 16;
    private static final int ITERATIONS = 1024;
    private static final int KEY_LENGTH = 256;

    public static void main(String[] args) {
        try {
            // Generate a random salt
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[SALT_LENGTH];
            random.nextBytes(salt);

            // Secret password (for demonstration purposes, you should get this securely in real use cases)
            char[] password = "secret".toCharArray();

            // Create the key specification
            KeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);

            // Generate the secret key
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            SecretKey key = f.generateSecret(spec);

            // Print the generated key and salt for demonstration
            byte[] keyBytes = key.getEncoded();
            System.out.println("Generated Key: " + bytesToHex(keyBytes));
            System.out.println("Generated Salt: " + bytesToHex(salt));

            // Store the generated AES-256 bit key and its corresponding salt for future use.
            // (For demonstration, we are just printing them out)
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    // Helper function to convert byte array to hex string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}