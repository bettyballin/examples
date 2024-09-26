import java.security.SecureRandom;

public class SecureRandomExample3 {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte[] values = new byte[128];
        random.nextBytes(values);
        System.out.println("Random bytes: ");
        for (byte b : values) {
            System.out.printf("%02x ", b);
        }
        System.out.println();
    }
}