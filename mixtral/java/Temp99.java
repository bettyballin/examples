import org.bouncycastle.crypto.params.KeyParameter;
import java.security.SecureRandom;

public class Temp99 {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte[] keyBytes = new byte[16]; // 128-bit key
        random.nextBytes(keyBytes);
        KeyParameter keyParameter = new KeyParameter(keyBytes);
        
        System.out.println("Generated key: " + bytesToHex(keyBytes));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}