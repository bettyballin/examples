import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "https://www.google.com/search?client=firefox-b-d&q=xsx+encoding+url";

        PolicyFactory policy = new HtmlPolicyBuilder()
                .allowElements("a")
                .allowUrlProtocols("http", "https")
                .requireRelNofollowOnLinks()
                .toFactory();

        String sanitizedURL = policy.sanitize(url);

        System.out.println(sanitizedURL);
    }
}