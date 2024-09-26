import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Temp185 {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/GCM/NoPadding";
    private static final int KEY_SIZE = 256;
    private static final int IV_SIZE = 12;
    private static final int TAG_BIT_LENGTH = 128;

    public static void main(String[] args) throws Exception {
        // Generate a random IV
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[IV_SIZE];
        random.nextBytes(iv);

        // Generate a random session key
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(KEY_SIZE);
        SecretKey sessionKey = keyGen.generateKey();

        // Example command
        String command = "Example command";
        byte[] commandBytes = command.getBytes("UTF-8");

        // Encrypt the data using the random IV
        byte[] encryptedData = encrypt(sessionKey, commandBytes, iv);

        // Decrypt the data using the same IV
        byte[] decryptedData = decrypt(sessionKey, encryptedData, iv);

        // Print decrypted data as a string
        System.out.println(new String(decryptedData, "UTF-8"));
    }

    public static byte[] encrypt(SecretKey key, byte[] data, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        GCMParameterSpec parameterSpec = new GCMParameterSpec(TAG_BIT_LENGTH, iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(SecretKey key, byte[] encryptedData, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        GCMParameterSpec parameterSpec = new GCMParameterSpec(TAG_BIT_LENGTH, iv);
        cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);
        return cipher.doFinal(encryptedData);
    }
}