import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;

public class Temp719 {
    public static void main(String[] args) {
        try {
            // Generate a temporary secret key for AES encryption
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // AES key size
            SecretKey secretKey = keyGen.generateKey();
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");

            // Initialize the cipher for encryption
            Cipher cipherEncryption = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipherEncryption.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            // Sample data to encrypt
            byte[] myFileContentBytes = "Hello, World!".getBytes();

            // Perform encryption
            byte[] encryptedData = new byte[cipherEncryption.getOutputSize(myFileContentBytes.length)];
            int encLen = cipherEncryption.update(myFileContentBytes, 0, myFileContentBytes.length, encryptedData, 0);
            encLen += cipherEncryption.doFinal(encryptedData, encLen);

            // Print encrypted data in hexadecimal format
            System.out.println(bytesToHex(encryptedData));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to convert bytes to a hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}