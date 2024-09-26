import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Temp368 {
    public static void main(String[] args) throws Exception {
        // Generate a new AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // for example, 128-bit key
        SecretKey secretKey = keyGen.generateKey();

        // Data to be encrypted
        String dataToEncrypt = "This is a secret message";
        byte[] dataToEncryptBytes = dataToEncrypt.getBytes();

        // Encrypt
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(dataToEncryptBytes);

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(secretKey.getEncoded(), "AES"));
        byte[] originalData = cipher.doFinal(encryptedData);

        // Print original data
        String originalDataStr = new String(originalData);
        System.out.println("Original Data: " + originalDataStr);
    }
}