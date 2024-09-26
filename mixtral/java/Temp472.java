import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class Temp472 {
    public static void main(String[] args) {
        try {
            String seed = "exampleSeed";
            String cleartext = "exampleCleartext";
            String encryptedText = encryptAES(seed, cleartext);
            System.out.println("Encrypted Text: " + encryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encryptAES(String seed, String cleartext) throws Exception {
        // Generate key from seed
        byte[] key = (seed).getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16); // use only first 128 bit

        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

        // Create cipher
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        // Encrypt the cleartext
        byte[] encrypted = cipher.doFinal(cleartext.getBytes("ASCII"));

        // Convert the cipher bytes into a base 64 encoding
        return Base64.getEncoder().encodeToString(encrypted);
    }
}