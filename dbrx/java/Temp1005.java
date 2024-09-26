import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class Temp1005 {
    public static void main(String[] args) {
        Temp1005 temp = new Temp1005();
        String input = "<script>alert('Hello');</script> Hello World!";
        String sanitized = temp.sanitize(input);
        System.out.println(sanitized);
    }

    private String sanitize(String input) {
        return Jsoup.clean(input, Whitelist.none().addTags("body"));
    }
}