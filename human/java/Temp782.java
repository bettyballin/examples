import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Temp782 {
    public static void main(String[] args) {
        try {
            // Generate AES key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // for example, 128-bit AES
            SecretKey secretKey = keyGen.generateKey();
            
            // Example plaintext
            byte[] plaintext = "1234567890123456".getBytes(); // 16 bytes of data

            // Create AES cipher instance
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedData = cipher.doFinal(plaintext);  // will be 16 bytes

            // Print encrypted data
            System.out.println("Encrypted Data: " + javax.xml.bind.DatatypeConverter.printHexBinary(encryptedData));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}