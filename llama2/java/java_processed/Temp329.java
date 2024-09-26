import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Temp329 {
    public static void main(String[] args) {
        try {
            // Generate a key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(192);
            SecretKey secretKey = keyGenerator.generateKey();

            // Generate an IV
            byte[] iv = new byte[16];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(iv);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            // Get Cipher instance
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");

            // Initialize the Cipher
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

            // Just a dummy plaintext
            byte[] plaintext = "This is a test.".getBytes();
            int blockSize = cipher.getBlockSize();
            int plaintextLength = plaintext.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength += (blockSize - (plaintextLength % blockSize));
            }
            byte[] paddedPlaintext = new byte[plaintextLength];
            System.arraycopy(plaintext, 0, paddedPlaintext, 0, plaintext.length);

            // Encrypt the plaintext
            byte[] ciphertext = cipher.doFinal(paddedPlaintext);

            // Print the ciphertext in Base64
            System.out.println("Ciphertext: " + Base64.getEncoder().encodeToString(ciphertext));

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 InvalidAlgorithmParameterException | IllegalBlockSizeException |
                 BadPaddingException e) {
            e.printStackTrace();
        }
    }
}