import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.SecureRandom;

public class Temp1279 {
    public static void main(String[] args) throws Exception {
        // Generate a secret key for AES encryption
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // AES-256
        SecretKey secretKey = keyGen.generateKey();

        // Generate a random IV
        byte[] iv = new byte[12];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);

        // Initialize the cipher for decryption
        Cipher d = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);
        d.init(Cipher.DECRYPT_MODE, secretKey, gcmSpec);

        // Decrypt your data (this is just a placeholder, real data must be provided)
        // byte[] ciphertext = ...;
        // byte[] decryptedData = d.doFinal(ciphertext);
    }
}