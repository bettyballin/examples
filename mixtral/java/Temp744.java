import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp744 {
    public static void main(String[] args) {
        try {
            int seedSize = 10; // Define seedSize to avoid compilation error
            long timestamp = System.nanoTime();
            SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");
            secureRandomGenerator.setSeed(timestamp);
            int[] seed = new int[seedSize];
            for (int i = 0; i < seedSize; ++i) {
                seed[i] = secureRandomGenerator.nextInt();
            }

            // Print the generated seed array for verification
            for (int value : seed) {
                System.out.println(value);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}