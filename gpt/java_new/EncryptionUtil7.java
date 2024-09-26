import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKeyFactory;
import java.security.spec.KeySpec;
import java.util.Base64;

public class EncryptionUtil7 {

    public static String decrypt(String encodedString, String sharedSecretKey, String salt, String iv) throws Exception {
        // Decode the base64 encoded string
        byte[] encryptedData = Base64.getDecoder().decode(encodedString);

        // Derive the AES key using PBKDF2 with the same parameters as in JavaScript
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(sharedSecretKey.toCharArray(), salt.getBytes(), 10000, 256);
        SecretKey secretKey = factory.generateSecret(spec);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");

        // Prepare the cipher with the same parameters as in JavaScript
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(iv.getBytes()));

        // Perform the decryption
        byte[] decryptedData = cipher.doFinal(encryptedData);

        // Convert decrypted data to string
        return new String(decryptedData);
    }

    public static void main(String[] args) {
        try {
            String encodedString = "your-encrypted-string";
            String sharedSecretKey = "your-shared-secret";
            String salt = "your-salt";
            String iv = "your-iv";

            String decryptedString = decrypt(encodedString, sharedSecretKey, salt, iv);
            System.out.println("Decrypted String: " + decryptedString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}