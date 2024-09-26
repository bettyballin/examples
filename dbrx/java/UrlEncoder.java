import org.owasp.encoder.Encode;

public class UrlEncoder {

    public String encodeUrl(String url) {
        // Encode URL for HTML context (e.g in a link)
        return Encode.forHtml(url);
    }

    public static void main(String[] args) {
        UrlEncoder encoder = new UrlEncoder();
        String url = "https://example.com/?query=java programming";
        System.out.println("Encoded URL: " + encoder.encodeUrl(url));
    }
}
// Add the OWASP Encoder dependency to your project
// If using Maven, add the following to your pom.xml:
// <dependency>
//     <groupId>org.owasp.encoder</groupId>
//     <artifactId>encoder</artifactId>
//     <version>1.2.3</version>
// </dependency>