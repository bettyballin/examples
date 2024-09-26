import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class Temp143 {
    public static void main(String[] args) {
        String unsafe = 
              "&lt;p&gt;&lt;a href='http://example.com/' onclick='stealCookies()'&gt;Link&lt;/a&gt;&lt;/p&gt;";
        String safe = Jsoup.clean(unsafe, Whitelist.basic());
        // now: &lt;p&gt;&lt;a href="http://example.com/" rel="nofollow"&gt;Link&lt;/a&gt;&lt;/p&gt;
        System.out.println(safe);
    }
}