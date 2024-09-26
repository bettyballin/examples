import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class SecureEncryption {
    private static final String ALGORITHM = "AES/GCM/NoPadding";
    private static final int IV_SIZE = 12; // 96 bits
    private static final int TAG_SIZE = 128; // 128 bits

    public byte[] encrypt(String plainText, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);

        SecureRandom secureRandom = new SecureRandom();

        // Generate a random IV
        byte[] iv = new byte[IV_SIZE];
        secureRandom.nextBytes(iv);
        GCMParameterSpec parameterSpec = new GCMParameterSpec(TAG_SIZE, iv);

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);

        byte[] cipherText = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));

        // Prepend IV to the cipherText
        byte[] cipherTextWithIv = new byte[IV_SIZE + cipherText.length];
        System.arraycopy(iv, 0, cipherTextWithIv, 0, IV_SIZE);
        System.arraycopy(cipherText, 0, cipherTextWithIv, IV_SIZE, cipherText.length);

        return cipherTextWithIv;
    }

    public String decrypt(byte[] cipherTextWithIv, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);

        // Extract IV from the cipherText
        byte[] iv = new byte[IV_SIZE];
        System.arraycopy(cipherTextWithIv, 0, iv, 0, IV_SIZE);
        GCMParameterSpec parameterSpec = new GCMParameterSpec(TAG_SIZE, iv);

        cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);

        byte[] cipherText = new byte[cipherTextWithIv.length - IV_SIZE];
        System.arraycopy(cipherTextWithIv, IV_SIZE, cipherText, 0, cipherText.length);

        byte[] plainText = cipher.doFinal(cipherText);

        return new String(plainText, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256); // 256-bit AES key
            SecretKey secretKey = keyGenerator.generateKey();

            SecureEncryption secureEncryption = new SecureEncryption();

            String plainText = "Hello, World!";
            byte[] cipherTextWithIv = secureEncryption.encrypt(plainText, secretKey);
            String cipherTextBase64 = Base64.getEncoder().encodeToString(cipherTextWithIv);
            System.out.println("Encrypted (Base64): " + cipherTextBase64);

            byte[] decodedCipherTextWithIv = Base64.getDecoder().decode(cipherTextBase64);
            String decryptedText = secureEncryption.decrypt(decodedCipherTextWithIv, secretKey);
            System.out.println("Decrypted: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}