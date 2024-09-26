import java.security.SecureRandom;

public class Temp2639 {
    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[16];
        secureRandom.nextBytes(randomBytes);

        System.out.println("Generated Random Bytes: ");
        for (byte b : randomBytes) {
            System.out.printf("%02x ", b);
        }
    }
}