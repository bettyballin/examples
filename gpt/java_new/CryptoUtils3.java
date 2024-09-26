import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class CryptoUtils3 {
    private static final String ENCRYPTION_ALGORITHM = "AES/CBC/PKCS5Padding";

    public static String encrypt(String plainText, SecretKeySpec encryptionKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        byte[] iv = generateRandomIV(16);
        cipher.init(Cipher.ENCRYPT_MODE, encryptionKey, new IvParameterSpec(iv));
        byte[] encryptedData = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        byte[] eDataAndIv = new byte[iv.length + encryptedData.length];
        System.arraycopy(iv, 0, eDataAndIv, 0, iv.length);
        System.arraycopy(encryptedData, 0, eDataAndIv, iv.length, encryptedData.length);
        return Base64.getEncoder().encodeToString(eDataAndIv);
    }

    private static byte[] generateRandomIV(int length) {
        byte[] iv = new byte[length];
        new SecureRandom().nextBytes(iv);
        return iv;
    }
}