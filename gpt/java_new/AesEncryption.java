import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class AesEncryption {
    public static void main(String[] args) throws Exception {
        String passphrase = "your-passphrase-here";
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt); // Randomly generated salt for each encryption
        int iterationCount = 65536;
        int keyLength = 256;

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), salt, iterationCount, keyLength);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] iv = new byte[cipher.getBlockSize()];
        random.nextBytes(iv);
        IvParameterSpec ivParams = new IvParameterSpec(iv);

        cipher.init(Cipher.ENCRYPT_MODE, secret, ivParams);
        String plaintext = "your-plaintext-here";
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes("UTF-8"));

        String encodedCiphertext = Base64.getEncoder().encodeToString(ciphertext);
        String encodedIv = Base64.getEncoder().encodeToString(iv);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);

        System.out.println("Ciphertext: " + encodedCiphertext);
        System.out.println("IV: " + encodedIv);
        System.out.println("Salt: " + encodedSalt);
    }
}