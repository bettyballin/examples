import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

public class HtmlWhitelisting {
    public static void main(String[] args) {
        String unsafeHtml = "<p><a href='http://example.com'>Click here</a> and <script>alert('Hello')</script> enjoy!</p>";
        Safelist safelist = Safelist.basic();

        safelist.addTags("p");
        safelist.addAttributes("a", "href");

        String safeHtml = Jsoup.clean(unsafeHtml, safelist);
        System.out.println(safeHtml);
    }
}