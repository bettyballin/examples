import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RepeatedSubstringFinder {
    public static void main(String[] args) {
        String sToDecode = "yourStringHere"; // Replace with the string you want to search
        int N = 10; // Set N to the minimum length of the repeating sequence you want to find
        String regex = "(?=(\\d{" + N + ",}?))(\\1)";
        Pattern patt = Pattern.compile(regex);
        Matcher matcher = patt.matcher(sToDecode);
        while (matcher.find()) {
            System.out.println("Repeated substring: " + matcher.group(1));
        }
    }
}