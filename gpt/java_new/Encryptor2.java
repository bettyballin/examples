import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.spec.KeySpec;
import java.io.IOException;
import java.io.File;

public class Encryptor2 {
    private static final String S_KEY_FACTORY_ALG = "PBKDF2WithHmacSHA256";
    private static final String CIPHER_ALG = "AES/CBC/PKCS5Padding";
    private static final int ITERATION_COUNT = 65536;
    private static final int KEY_LENGTH = 256;
    private static final byte[] SALT = new byte[] { 
        (byte) 0x23, (byte) 0x45, (byte) 0x67, (byte) 0x89,
        (byte) 0xab, (byte) 0xcd, (byte) 0xef, (byte) 0x01
    };

    private byte[] encrypt(File file, String password) throws Exception {
        Path path = Paths.get(file.toURI());
        byte[] messageBytes = Files.readAllBytes(path);

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(S_KEY_FACTORY_ALG);
        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), SALT, ITERATION_COUNT, KEY_LENGTH);
        SecretKey secretKey = keyFactory.generateSecret(keySpec);
        Cipher cipher = Cipher.getInstance(CIPHER_ALG);

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] cipherBytes = cipher.doFinal(messageBytes);
        byte[] iv = cipher.getIV();

        // Combine the IV and encrypted data
        byte[] encryptedData = new byte[iv.length + cipherBytes.length];
        System.arraycopy(iv, 0, encryptedData, 0, iv.length);
        System.arraycopy(cipherBytes, 0, encryptedData, iv.length, cipherBytes.length);

        return encryptedData;
    }
}