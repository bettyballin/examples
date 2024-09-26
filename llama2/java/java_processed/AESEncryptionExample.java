import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Arrays;

public class AESEncryptionExample {
    public static void main(String[] args) throws Exception {
        // Define the encryption algorithm
        String algorithm = "AES/CBC/PKCS5Padding";

        // Generate a random secret key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secret = keyGen.generateKey();

        // Create an instance of the cipher
        Cipher cipher = Cipher.getInstance(algorithm);

        // Generate IV
        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // Initialize the cipher with the secret key and IV for encryption
        cipher.init(Cipher.ENCRYPT_MODE, secret, ivSpec);

        // Define the data to encrypt
        String plaintext = "Hello World!";
        byte[] plaintextBytes = plaintext.getBytes();
        byte[] plaintextPadded = Arrays.copyOf(plaintextBytes, (plaintextBytes.length + 15) / 16 * 16); // Pad plaintext to multiple of block size

        // Encrypt the data
        byte[] encryptedData = cipher.doFinal(plaintextPadded);

        System.out.println("Encrypted Data: " + bytesToHexString(encryptedData));

        // Initialize the cipher with the secret key and IV for decryption
        cipher.init(Cipher.DECRYPT_MODE, secret, ivSpec);
        byte[] decryptedData = cipher.doFinal(encryptedData);

        System.out.println("Decrypted Data: " + new String(decryptedData).trim());
    }

    private static String bytesToHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}