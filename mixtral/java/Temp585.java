import java.util.Arrays;
import java.util.Base64;

public class Temp585 {
    public static void main(String[] args) {
        byte[] decoded = Base64.getDecoder().decode("your_encrypted_string");

        // Extract salt
        byte[] saltBytes = Arrays.copyOfRange(decoded, 0, 8);

        // Extract IV
        byte[] ivBytes = Arrays.copyOfRange(decoded, 8, 24);

        // Get ciphertext
        int length = decoded.length;
        byte[] encryptedText = new byte[length - 32];
        System.arraycopy(decoded, 24, encryptedText, 0, length - 32);
        
        // Print the extracted values for verification
        System.out.println("Salt: " + Arrays.toString(saltBytes));
        System.out.println("IV: " + Arrays.toString(ivBytes));
        System.out.println("Encrypted Text: " + Arrays.toString(encryptedText));
    }
}