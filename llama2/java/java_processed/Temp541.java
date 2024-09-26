import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

public class Temp541 {
    public static void main(String[] args) {
        // Create a policy that disables sanitizing URLs
        PolicyFactory policy = new HtmlPolicyBuilder().toFactory();

        // Input user-provided link
        String inputLink = "https://example.com?query=test";

        // Sanitize the link
        String outputLink = policy.sanitize(inputLink);

        // Print the encoded URL
        System.out.println(outputLink);
    }
}