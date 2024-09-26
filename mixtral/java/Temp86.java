import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Arrays;
import org.apache.commons.codec.binary.Base64;

@RestController
public class Temp86 {

    private static final String ALGO = "AES/CBC/PKCS5PADDING";

    @RequestMapping(value = "/util/encrypt/")
    public String encrypt() throws Exception {
        // Generate a random IV
        byte[] ivBytes = new byte[16];
        SecureRandom.getInstanceStrong().nextBytes(ivBytes);

        IvParameterSpec ivParamSpec = new IvParameterSpec(ivBytes);

        // Assuming 'key' and 'cipher' are correctly initialized elsewhere
        byte[] key = new byte[16]; // Replace with your actual key
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, new javax.crypto.spec.SecretKeySpec(key, "AES"), ivParamSpec);

        // Add your encryption logic here

        return "Encrypted data"; // Replace with actual encrypted data
    }

    @RequestMapping(value = "/util/decrypt/")
    public String decrypt(String token) throws Exception {
        // Extract the IV from encrypted data
        byte[] tokenBytes = Base64.decodeBase64(token);

        IvParameterSpec ivParamSpec = new IvParameterSpec(Arrays.copyOfRange(tokenBytes, 0, 16));

        // Assuming 'key' and 'cipher' are correctly initialized elsewhere
        byte[] key = new byte[16]; // Replace with your actual key
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.DECRYPT_MODE, new javax.crypto.spec.SecretKeySpec(key, "AES"), ivParamSpec);

        // Add your decryption logic here

        return "Decrypted data"; // Replace with actual decrypted data
    }

    public static void main(String[] args) {
        // Main method for testing purposes if needed
        // Spring Boot application would run differently
    }
}