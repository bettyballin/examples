import java.security.SecureRandom;
import java.util.Formatter;

public class Temp193 {
    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[16];
        secureRandom.nextBytes(key);

        // Print the generated key in hex format
        StringBuilder hexString = new StringBuilder();
        for (byte b : key) {
            hexString.append(String.format("%02x", b));
        }
        System.out.println("Generated key: " + hexString.toString());
    }
}