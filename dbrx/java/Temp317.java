import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Temp317 {
    public static void main(String[] args) throws Exception {
        // Generate a new key
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        keygen.init(128);
        SecretKey key = keygen.generateKey();

        // Encrypt the secret string.
        String secretString = "This is a secret";
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] iv = cipher.getIV(); // Get the initialization vector
        byte[] encryptedData = cipher.doFinal(secretString.getBytes());

        // Store it in SharedPreferences or any other persistent storage.
        // For demonstration, we simply print the encrypted data and IV
        System.out.println("Encrypted Data: " + Base64.getEncoder().encodeToString(encryptedData));
        System.out.println("IV: " + Base64.getEncoder().encodeToString(iv));

        // Decrypt and retrieve when needed:
        Cipher decipher = Cipher.getInstance("AES/GCM/NoPadding");
        decipher.init(Cipher.DECRYPT_MODE, key, new GCMParameterSpec(128, iv));
        byte[] decryptedData = decipher.doFinal(encryptedData);
        String secretStringBack = new String(decryptedData);

        // Print the decrypted string
        System.out.println("Decrypted String: " + secretStringBack);
    }
}