import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class AESCipher {
    private static final String ALGORITHM = "AES";
    private final SecretKey key;

    public AESCipher(String key) throws NoSuchAlgorithmException {
        this.key = generateKey(key);
    }

    private SecretKey generateKey(String keyStr) throws NoSuchAlgorithmException {
        byte[] keyBytes = keyStr.getBytes();
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        SecureRandom secureRandom = new SecureRandom(keyBytes);
        keyGen.init(128, secureRandom);
        return new SecretKeySpec(keyBytes, ALGORITHM);
    }

    public String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted);
    }

    public static void main(String[] args) {
        try {
            String key = "mysecretpassword";
            AESCipher aesCipher = new AESCipher(key);
            
            String originalString = "Hello, World!";
            String encryptedString = aesCipher.encrypt(originalString);
            String decryptedString = aesCipher.decrypt(encryptedString);
            
            System.out.println("Original: " + originalString);
            System.out.println("Encrypted: " + encryptedString);
            System.out.println("Decrypted: " + decryptedString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}