import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class Temp783 {
    public static void main(String[] args) throws Exception {
        // Generate a key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // for example
        SecretKey secretKey = keyGen.generateKey();
        
        // Create a Cipher instance
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

        // GCM requires an IV
        byte[] iv = new byte[12];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(iv);
        GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);

        // Initialize the cipher for encryption
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmSpec);

        // Example plaintext
        byte[] plaintext = "Hello World".getBytes();

        // Encrypt the plaintext
        byte[] ciphertext = cipher.doFinal(plaintext);

        // Print the ciphertext (in hex format)
        System.out.println(bytesToHex(ciphertext));
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