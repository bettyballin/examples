import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class RandomNumberGenerator1 {

    public static void main(String[] args) {
        int maxRange = 30; // Use 30 for a range of [0, 30]
        int indicesLength = 7; // Change to 6, 7, or 9 as needed

        SecureRandom secureRandom = new SecureRandom();
        int[] digestCodeIndicesArr = new int[indicesLength];
        Set<Integer> generatedNumbers = new HashSet<>();

        int i = 0;
        while (i < indicesLength) {
            int randomTemp = secureRandom.nextInt(maxRange + 1); // nextInt is exclusive, hence +1
            if (generatedNumbers.add(randomTemp)) {
                digestCodeIndicesArr[i++] = randomTemp;
            }
        }

        // Print the unique random numbers for verification
        for (int number : digestCodeIndicesArr) {
            System.out.println(number);
        }
    }
}