import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

public class Temp1201 {
    public static void main(String[] args) {
        String input = "<html><body><h1>Hello, world!</h1></body></html>"; // Example input
        PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
        String cleanHtml = policy.sanitize(input);
        
        System.out.println(cleanHtml); // Proceed to process the sanitized input
    }
}