import java.security.SecureRandom;

public class Temp417 {
    public static void main(String[] args) {
        byte[] seed = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(seed);

        // Printing the generated seed for verification
        System.out.print("Generated seed: ");
        for (byte b : seed) {
            System.out.printf("%02x", b);
        }
        System.out.println();
    }
}