import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class HmacExample {
    public static void main(String[] args) throws Exception {
        // Generate a random key
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
        keyGen.init(256); // Initialize the key size
        SecretKey key = keyGen.generateKey();

        // Get the raw key bytes
        byte[] keyBytes = key.getEncoded();

        // Create a message to sign
        String message = "Hello world!";
        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);

        // Calculate the Hmac
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(key);
        byte[] hmacBytes = mac.doFinal(messageBytes);

        // Print the Hmac
        System.out.println("HMAC: " + Arrays.toString(hmacBytes));
    }
}