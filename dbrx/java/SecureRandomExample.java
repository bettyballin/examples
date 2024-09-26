import java.security.SecureRandom;

public class SecureRandomExample {
    public static void main(String[] args) throws Exception {
        int entropyBits = 226;
        double bytesNeededDouble = (double)entropyBits / 8.0; // convert bits to bytes
        long bytesNeededLong = (long)Math.ceil(bytesNeededDouble); // round up if necessary

        byte[] seedBytes = new byte[(int)bytesNeededLong];
        SecureRandom random = new SecureRandom();
        random.nextBytes(seedBytes);

        System.out.println("Generated " + entropyBits + " bits of randomness.");
    }
}