import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;

public class Temp631 {
    public static void main(String[] args) {
        try {
            /* Store these things on disk used to derive key later: */
            int iterationCount = 1000;
            int saltLength = 32; // bytes; should be the same size as the output (256 / 8 = 32)
            int keyLength = 256; // 256-bits for AES-256, 128-bits for AES-128, etc
            byte[] salt = new byte[saltLength]; // Should be of saltLength

            /* When first creating the key, obtain a salt with this: */
            SecureRandom random = new SecureRandom();
            random.nextBytes(salt);

            String password = "your_password_here"; // Replace with your password

            /* Use this to derive the key from the password: */
            KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, iterationCount, keyLength);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] keyBytes = keyFactory.generateSecret(keySpec).getEncoded();
            SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");

            byte[] encodedKey = secretKey.getEncoded();
            System.out.println("Encoded Key: " + bytesToHex(encodedKey));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}