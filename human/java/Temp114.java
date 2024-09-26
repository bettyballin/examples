import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

public class Temp114 {
    public static void main(String[] args) {
        String unsafe = "<p><a href='http://example.com/' onclick='stealCookies()'>Link</a></p>";
        String safe = Jsoup.clean(unsafe, Safelist.basic());
        System.out.println(safe);
        // now: <p><a href="http://example.com/" rel="nofollow">Link</a></p>
    }
}