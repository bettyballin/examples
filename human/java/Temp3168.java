import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Encryptor {
    public static void main(String[] args) {
        String secretKey = "mySuperSecretKey";
        String strToEncrypt = "Hello, World!";
        String encryptedStr = encrypt(strToEncrypt, secretKey);
        System.out.println("Encrypted: " + encryptedStr);
    }

    public static String encrypt(String strToEncrypt, String secretKey) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] salt = new byte[16];
            SecureRandom.getInstanceStrong().nextBytes(salt);
            KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt, 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secret);
            byte[] iv = cipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            byte[] ciphertext = cipher.doFinal(strToEncrypt.getBytes("UTF-8"));
            System.out.println("Finished encryption");

            byte[] outputBytes = concat(concat(salt, iv), ciphertext);
            return Base64.getEncoder().encodeToString(outputBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] concat(byte[] first, byte[] second) {
        byte[] result = new byte[first.length + second.length];
        System.arraycopy(first, 0, result, 0, first.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}