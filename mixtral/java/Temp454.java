import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.util.Base64;

public class Temp454 {
    public static void main(String[] args) {
        try {
            // Generate AES key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            SecretKey secretKey = keyGen.generateKey();

            // Data to encrypt
            String dataToEncrypt = "This is a secret message";
            byte[] dataToEncryptBytes = dataToEncrypt.getBytes();

            // Initialize cipher
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            byte[] iv = new byte[12]; // GCM recommended 12 bytes IV
            GCMParameterSpec spec = new GCMParameterSpec(128, iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, spec);

            // Encrypt the data
            byte[] encryptedBytes = cipher.doFinal(dataToEncryptBytes);

            // Encode to base64
            String encodedData = Base64.getUrlEncoder().encodeToString(encryptedBytes);
            System.out.println("Encoded data: " + encodedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}