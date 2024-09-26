import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class Temp1554 {
    public static void main(String[] args) {
        byte[] encodedKey = new byte[32]; // Example byte array, replace with actual key

        if (encodedKey.length < 32) {
            // Use existing method for backward compatibility
            System.out.println("Backward compatibility method.");
        } else {
            SecretKeySpec aesKey = new SecretKeySpec(Arrays.copyOfRange(encodedKey, 0, 32), "AES");
            System.out.println("AES Key created: " + aesKey);
        }
    }
}