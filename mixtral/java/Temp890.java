import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Temp890 {
    public static void main(String[] args) {
        int max_range = 31;
        int indicesLength = 10;  // Assuming some value for indicesLength
        SecureRandom secureRandom = new SecureRandom();
        List<Integer> numbers = IntStream.rangeClosed(0, max_range)
                                         .boxed()
                                         .collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(numbers, secureRandom);
        int[] digestCodeIndicesArr = new int[indicesLength];
        for (int i = 0; i < indicesLength && i <= max_range ; ++i) {
            digestCodeIndicesArr[i] = numbers.get(i).intValue();
        }

        // Print the array to verify the output
        for (int i = 0; i < digestCodeIndicesArr.length; i++) {
            System.out.print(digestCodeIndicesArr[i] + " ");
        }
    }
}