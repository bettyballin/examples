import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.*;

public class AESCBC {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    public byte[] encrypt(byte[] data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecureRandom randomSecureRandom = new SecureRandom();

        // Create a 16 bytes IV
        byte[] ivBytes = new byte[cipher.getBlockSize()];
        randomSecureRandom.nextBytes(ivBytes);
        IvParameterSpec ivParams = new IvParameterSpec(ivBytes);

        cipher.init(Cipher.ENCRYPT_MODE, key, ivParams);
        byte[] encryptedData = cipher.doFinal(data);

        // Combine IV and encrypted data
        byte[] combined = new byte[ivBytes.length + encryptedData.length];
        System.arraycopy(ivBytes, 0, combined, 0, ivBytes.length);
        System.arraycopy(encryptedData, 0, combined, ivBytes.length, encryptedData.length);

        return combined;
    }

    public byte[] decrypt(byte[] data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);

        // Extract IV
        byte[] ivBytes = new byte[cipher.getBlockSize()];
        System.arraycopy(data, 0, ivBytes, 0, ivBytes.length);
        IvParameterSpec ivParams = new IvParameterSpec(ivBytes);

        // Extract encrypted data
        byte[] encryptedData = new byte[data.length - ivBytes.length];
        System.arraycopy(data, ivBytes.length, encryptedData, 0, encryptedData.length);

        cipher.init(Cipher.DECRYPT_MODE, key, ivParams);

        return cipher.doFinal(encryptedData);
    }

    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // For example, use 256-bit AES key
        SecretKey secretKey = keyGen.generateKey();

        String originalText = "Hello, World!";
        byte[] originalBytes = originalText.getBytes();

        AESCBC aesCbc = new AESCBC();
        byte[] encryptedBytes = aesCbc.encrypt(originalBytes, secretKey);
        byte[] decryptedBytes = aesCbc.decrypt(encryptedBytes, secretKey);

        String decryptedText = new String(decryptedBytes);

        System.out.println("Original: " + originalText);
        System.out.println("Decrypted: " + decryptedText);
    }
}