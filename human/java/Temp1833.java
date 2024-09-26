import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Base64;
import java.util.Random;

public class Temp1833 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        System.out.println("ct: " + encrypt("plaintext", "test"));
    }

    public static String encrypt(String plaintext, String password) {
        try {
            byte[] iv = new byte[16];
            new Random().nextBytes(iv);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);

            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] keyBytes = sha.digest(password.getBytes());
            keyBytes = java.util.Arrays.copyOf(keyBytes, 16); // use only first 128 bit
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);

            byte[] encrypted = cipher.doFinal(plaintext.getBytes());

            byte[] combined = new byte[iv.length + encrypted.length];
            System.arraycopy(iv, 0, combined, 0, iv.length);
            System.arraycopy(encrypted, 0, combined, iv.length, encrypted.length);

            return Base64.getEncoder().encodeToString(combined);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}