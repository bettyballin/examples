import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class AESEncryption {
    public static void main(String[] args) throws Exception {
        // Define the encryption algorithm and key
        String algorithm = "AES";
        byte[] key = Arrays.copyOf("my_secret_key".getBytes(), 16); // Ensure key is 16 bytes long

        // Create a SecretKeySpec object
        SecretKeySpec sks = new SecretKeySpec(key, algorithm);

        // Create a Cipher object
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, sks);

        // Encrypt the data
        String plaintext = "This is the plain text message";
        byte[] plaintextBytes = plaintext.getBytes();
        byte[] encryptedBytes = cipher.doFinal(plaintextBytes);

        System.out.println("Encrypted message: ");
        for (int i = 0; i < encryptedBytes.length; i++) {
            System.out.print(encryptedBytes[i] + " ");
        }
    }
}