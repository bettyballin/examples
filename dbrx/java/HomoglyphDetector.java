import java.text.Normalizer;
import java.util.HashSet;

public class HomoglyphDetector {
    private static final HashSet<Character.UnicodeScript> ALLOWED_SCRIPTS = new HashSet<>();

    // Add allowed script codes here (e.g Latin Greek)
    static {
        ALLOWED_SCRIPTS.add(Character.UnicodeScript.LATIN);
        ALLOWED_SCRIPTS.add(Character.UnicodeScript.GREEK);
    }

    public boolean isHomoglyph(String input) {
        String normalizedInput = Normalizer.normalize(input, Normalizer.Form.NFC);

        for (int i = 0; i < normalizedInput.length(); ++i) {
            int codePoint = normalizedInput.codePointAt(i);
            if (!ALLOWED_SCRIPTS.contains(Character.UnicodeScript.of(codePoint))) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        HomoglyphDetector detector = new HomoglyphDetector();
        System.out.println(detector.isHomoglyph("Hello")); // Should return false
        System.out.println(detector.isHomoglyph("Ηello")); // Should return true (Greek capital letter Eta instead of Latin H)
    }
}