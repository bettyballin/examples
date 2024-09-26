import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Temp1349 {
    public static void main(String[] args) {
        try {
            // Generate a key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();

            // Create a Cipher instance
            Cipher cipher = Cipher.getInstance("AES");

            // Encrypt some data
            String plainText = "Hello World!";
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedOut = cipher.doFinal(plainText.getBytes());

            // Decrypt the data
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            String decryptedOut = new String(cipher.doFinal(encryptedOut));

            // Print the decrypted output
            System.out.println("Decrypted text: " + decryptedOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}