import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESUtils {

    private SecretKey secretKey;
    private Cipher cipher;
    private IvParameterSpec ivParams;

    public AESUtils() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            this.secretKey = keyGen.generateKey();

            this.cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] ivBytes = new byte[cipher.getBlockSize()];
            SecureRandom random = SecureRandom.getInstanceStrong();
            random.nextBytes(ivBytes);
            this.ivParams = new IvParameterSpec(ivBytes);
            this.cipher.init(Cipher.ENCRYPT_MODE, this.secretKey, this.ivParams);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] encrypt(byte[] data) throws Exception {
        return this.cipher.doFinal(data);
    }

    public byte[] decrypt(byte[] encryptedData) throws Exception {
        Cipher decryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        decryptCipher.init(Cipher.DECRYPT_MODE, this.secretKey, this.ivParams);
        return decryptCipher.doFinal(encryptedData);
    }

    public static void main(String[] args) {
        try {
            AESUtils aesUtils = new AESUtils();
            String originalText = "Hello, World!";
            byte[] encrypted = aesUtils.encrypt(originalText.getBytes());
            byte[] decrypted = aesUtils.decrypt(encrypted);

            System.out.println("Original: " + originalText);
            System.out.println("Encrypted: " + java.util.Arrays.toString(encrypted));
            System.out.println("Decrypted: " + new String(decrypted));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}