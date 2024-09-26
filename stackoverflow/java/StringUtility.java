import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtility {

    private static final Pattern DIACRITICS_AND_FRIENDS =
            Pattern.compile("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");

    public static String stripDiacritics(String str) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        str = DIACRITICS_AND_FRIENDS.matcher(str).replaceAll("");
        return str;
    }
    
    // This method can be tested with the main method or other testing approaches.
    public static void main(String[] args) {
        String original = "Crème Brûlée";
        String stripped = stripDiacritics(original);
        System.out.println(stripped); // Should print "Creme Brulee" without diacritics
    }
}