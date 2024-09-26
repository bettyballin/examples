import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Main39 {
    private static final String AES_TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final String AES_ALGORITHM = "AES";
    private static final int IV_SIZE = 16;
    private static final int KEY_SIZE = 128;

    public static void main(String[] args) throws Exception {
        // Generate Key
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES_ALGORITHM);
        keyGenerator.init(KEY_SIZE);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] keyBytes = secretKey.getEncoded();
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, AES_ALGORITHM);

        // Generate IV
        byte[] iv = new byte[IV_SIZE];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // Encrypt
        Cipher cipher = Cipher.getInstance(AES_TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        String plainText = "Hello, World!";
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        String encoded = Base64.getEncoder().encodeToString(encryptedBytes);

        System.out.println("Encrypted and encoded: " + encoded);

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encoded));
        String decryptedText = new String(decryptedBytes);

        System.out.println("Decrypted text: " + decryptedText);
    }
}