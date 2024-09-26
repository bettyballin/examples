import java.security.SecureRandom;
import java.util.Arrays;

public class Temp659 {
    public static void main(String[] args) {
        int max_range = 31;
        SecureRandom secureRandom = new SecureRandom();
        int indices_length = 10; // Assuming a length for the example
        int[] digestCodeIndicesArr = new int[indices_length];
        int random_temp;

        for (int i = 0; i < indices_length; i++) {
            do {
                random_temp = secureRandom.nextInt(max_range);
            } while (contains(digestCodeIndicesArr, random_temp, i));
            
            digestCodeIndicesArr[i] = random_temp;
        }

        System.out.println(Arrays.toString(digestCodeIndicesArr));
    }

    private static boolean contains(int[] arr, int key, int length) {
        for (int i = 0; i < length; i++) {
            if (arr[i] == key) {
                return true;
            }
        }
        return false;
    }
}