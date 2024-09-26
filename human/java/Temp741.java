import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class Temp741 {
    public static void main(String[] args) {
        // SecureRandom is expensive to initialize (takes several milliseconds) –
        // consider keeping the instance around if you are generating many keys.
        SecureRandom random = new SecureRandom();
        byte[] keyBytes = new byte[16];
        random.nextBytes(keyBytes);
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

        // For demonstration purposes, print the generated key in hexadecimal format
        System.out.println(bytesToHex(keyBytes));
    }

    // Helper method to convert byte array to hexadecimal string
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}