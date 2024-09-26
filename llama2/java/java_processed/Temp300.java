import java.security.SecureRandom;

public class Temp300 {
    public static void main(String[] args) {
        byte[] iv = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(iv);
        
        // Print the generated IV for demonstration
        System.out.print("Generated IV: ");
        for (byte b : iv) {
            System.out.printf("%02x ", b);
        }
    }
}