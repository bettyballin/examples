import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.binary.Hex;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptionUtil3 {

    public static String encrypt(String plaintext, String password) throws Exception {
        SecureRandom random = new SecureRandom();
        byte[] ivBytes = new byte[16];
        random.nextBytes(ivBytes);
        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        byte[] keyBytes = DigestUtils.sha1(password);
        byte[] keyBytes16 = new byte[16];
        System.arraycopy(keyBytes, 0, keyBytes16, 0, Math.min(keyBytes.length, 16));
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes16, "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);

        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes("UTF-8"));
        byte[] encryptedIVAndText = new byte[ivBytes.length + encryptedBytes.length];
        System.arraycopy(ivBytes, 0, encryptedIVAndText, 0, ivBytes.length);
        System.arraycopy(encryptedBytes, 0, encryptedIVAndText, ivBytes.length, encryptedBytes.length);

        return Base64.getEncoder().encodeToString(encryptedIVAndText);
    }

    public static void main(String[] args) {
        try {
            System.out.println("ct: " + encrypt("plaintext", "test"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}