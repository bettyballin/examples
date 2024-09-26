import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class Temp206 {
    public static void main(String[] args) {
        byte[] keyBytes = new byte[24]; // Example initialization, adjust as needed
        byte[] newKeyBytes = Arrays.copyOf(keyBytes, 24);
        SecretKeySpec newKey = new SecretKeySpec(newKeyBytes, "DESede");
    }
}