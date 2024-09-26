import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Temp541 {
    public static void main(String[] args) {
        try {
            // Generate a DES key
            KeyGenerator keyGen = KeyGenerator.getInstance("DES");
            SecretKey secretKey = keyGen.generateKey();

            // Create a DES cipher object and initialize it to encrypt mode
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Sample data to encrypt
            String data = "Hello, World!";
            byte[] encryptedData = cipher.doFinal(data.getBytes());
            
            System.out.println("Encrypted Data: " + new String(encryptedData));

            // Initialize the cipher to decrypt mode
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedData = cipher.doFinal(encryptedData);

            System.out.println("Decrypted Data: " + new String(decryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}