import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class EncryptPassword {
    public static void main(String[] args) throws Exception {

        // Generate secret key for encryption/decryption
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // Ensure key size is set
        SecretKey secretKey = keyGen.generateKey();

        Cipher cipher = Cipher.getInstance("AES");

        String passwordToEncrypt = "myPassword";

        byte[] encryptedBytes;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            encryptedBytes = cipher.doFinal(passwordToEncrypt.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Print the encrypted bytes in base64 encoding for testing purposes
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        System.out.println("Encrypted Password: " + encoder.encodeToString(encryptedBytes));

        // Store the salt and key in a secure place
    }
}