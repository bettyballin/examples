import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Temp628 {
    public static void main(String[] args) {
        Temp628 temp = new Temp628();
        String testId = "abc123";
        System.out.println(temp.getArticleImageUrl(testId));
    }

    public String getArticleImageUrl(@Pattern(regexp = "^[a-zA-Z0-9]*$") String id) {
        if(id == null) return "Invalid ID: null";
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]*$");
        Matcher matcher = pattern.matcher(id);
        if (matcher.matches()) {
            return "URL for article with ID: " + id;
        } else {
            return "Invalid ID: " + id;
        }
    }
}