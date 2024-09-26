import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp1638 {
    public static void main(String[] args) {
        try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            byte[] seed = new byte[20]; // Example seed
            sr.setSeed(seed);
            // Now you can use this instance for generating random numbers
            long nextLongValue = sr.nextLong();
            System.out.println("Generated long value: " + nextLongValue);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}