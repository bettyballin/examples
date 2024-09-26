import java.text.Normalizer;
import java.util.regex.Pattern;

public class Temp972 {
    private static final Pattern DIACRITICS_AND_FRIENDS = Pattern.compile("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");

    private static String stripDiacritics(String str) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        str = DIACRITICS_AND_FRIENDS.matcher(str).replaceAll("");
        return str;
    }

    public static void main(String[] args) {
        String input = "Café naïve résumé coöperate";
        String output = stripDiacritics(input);
        System.out.println("Original: " + input);
        System.out.println("Stripped: " + output);
    }
}