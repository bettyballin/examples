import java.util.regex.*;

public class Temp1536 {
    public static void main(String[] args) {
        String input = "/user.html";
        String patternString = "\\A/user(\\.(?:html|other_filetype))?\\Z";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            System.out.println("Input matches the pattern.");
        } else {
            System.out.println("Input does not match the pattern.");
        }
    }
}