import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Temp320 {

    public static void main(String[] args) {
        Temp320 temp = new Temp320();
        String encrypted = temp.encrypt("Hello World");
        System.out.println("Encrypted: " + encrypted);
    }

    public String encrypt(String input) {
        try {
            Crypto crypto = new Crypto();
            SecretKeySpec key = crypto.hashPhrase();
            Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
            aes.init(Cipher.ENCRYPT_MODE, key);

            byte[] encryptedBytes = aes.doFinal(input.getBytes());

            // Convert the bytes to Base64 string
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Failed during encryption", e);
        }
    }

    // Dummy Crypto class for demonstration
    static class Crypto {
        public SecretKeySpec hashPhrase() {
            // For demonstration purposes, using a fixed key
            byte[] key = "1234567890123456".getBytes();
            return new SecretKeySpec(key, "AES");
        }
    }
}