import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Temp925 {
    public static void main(String[] args) {
        // Replace "your_encrypted_bytes_here" with actual byte data
        byte[] encryptedBytes = "your_encrypted_bytes_here".getBytes(StandardCharsets.UTF_8); // or however you get your bytes

        String smsMessage = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println(smsMessage); // Print the Base64 encoded string
    }
}