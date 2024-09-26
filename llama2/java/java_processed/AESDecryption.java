import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Arrays;

public class AESDecryption {
    public static void main(String[] args) throws Exception {
        // Example encrypted data (must be a multiple of 16 bytes)
        byte[] encrypted = new byte[]{ /* insert encrypted bytes here */ };

        // Secret key (must be 16 bytes for AES-128)
        String secretKey = "my_secret_key_16"; // Ensure this is exactly 16 bytes
        byte[] iv = new byte[16]; // Initialization vector (IV) - can be all zeros or another value

        // Initialize cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

        // Decrypt block by block
        int blockSize = 16;
        byte[] decryptedBlock = new byte[blockSize];
        byte[] decrypted = new byte[encrypted.length];
        for (int i = 0; i < encrypted.length; i += blockSize) {
            decryptedBlock = cipher.doFinal(encrypted, i, blockSize);
            System.arraycopy(decryptedBlock, 0, decrypted, i, blockSize);
        }

        // Print decrypted result (assuming it's a string)
        System.out.println(new String(decrypted).trim());
    }
}