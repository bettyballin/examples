import java.util.ArrayList;
import java.util.List;

public class StringCombinations {
    private static final String SALTCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_$#-~";

    public static void main(String[] args) {
        int maxLength = 10;
        List<String> combinations = new ArrayList<>();
        generateCombinations("", maxLength, combinations);
    }

    private static void generateCombinations(String prefix, int maxLength, List<String> combinations) {
        if (prefix.length() == maxLength) {
            combinations.add(prefix);
            return;
        }

        for (int i = 0; i < SALTCHARS.length(); i++) {
            String newPrefix = prefix + SALTCHARS.charAt(i);
            generateCombinations(newPrefix, maxLength, combinations);
        }
    }
}