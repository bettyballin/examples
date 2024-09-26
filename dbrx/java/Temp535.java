import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Arrays;

public class Temp535 {
    public static void main(String[] args) {
        try {
            // Generate a key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey key = keyGen.generateKey();

            // Create an initialization vector (IV)
            byte[] iv = new byte[16];
            Arrays.fill(iv, (byte) 0x00);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);

            // Data to encrypt
            String dataToEncrypt = "Hello, World!";
            byte[] dataBytes = dataToEncrypt.getBytes();

            // Initialize the cipher
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);

            // Perform encryption
            byte[] encryptedData = cipher.doFinal(dataBytes);

            // Print encrypted data in Base64
            System.out.println("Encrypted Data: " + Base64.getEncoder().encodeToString(encryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}