import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniqueNineDigitNumberGenerator {
    private final Random random = new Random();
    private final Set<Integer> generatedNumbers = new HashSet<>();

    public int generateUniqueNumber() {
        int number;
        do {
            number = 100000000 + random.nextInt(900000000);
        } while (!generatedNumbers.add(number));
        return number;
    }
}