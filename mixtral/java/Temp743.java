import java.security.SecureRandom;

public class Temp743 {
    public static void main(String[] args) {
        SecureRandom secureRandomGenerator = new SecureRandom();
        int seedSize = 10; // Define seedSize to avoid compilation error
        int[] seed = new int[seedSize];
        for(int i = 0; i < seedSize; ++i) {
            seed[i] = secureRandomGenerator.nextInt(Integer.MAX_VALUE);
        }

        // Print the generated seed values for verification
        for (int value : seed) {
            System.out.println(value);
        }
    }
}