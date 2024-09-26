import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Arrays;

public class Temp116 {
    public static void main(String[] args) {
        try {
            // Define your custom key and IV
            String key = "my_secret_key_16"; // Key should be 16 bytes for AES-128
            String iv = "my_initialization_vector_16"; // IV should be 16 bytes

            // Create a Cipher instance using the specified key and IV
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());

            // Initialize the cipher for encryption
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

            // Encrypt your data
            String plaintext = "This is a test message.";
            byte[] plaintextBytes = plaintext.getBytes();
            int blockSize = cipher.getBlockSize();
            int paddedSize = (int) Math.ceil((double) plaintextBytes.length / blockSize) * blockSize;
            byte[] paddedPlaintext = Arrays.copyOf(plaintextBytes, paddedSize); // NoPadding requires block-size aligned input

            byte[] encryptedBytes = cipher.doFinal(paddedPlaintext);

            // Print encrypted data
            System.out.println("Encrypted data: " + Arrays.toString(encryptedBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}