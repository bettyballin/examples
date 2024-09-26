import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.DefaultCsrfToken;

public class Temp456 {
    public static void main(String[] args) {
        // Creating a CSRF token
        CsrfToken csrfToken = new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", "your-session-id");
        
        // Output the token information
        System.out.println("Header Name: " + csrfToken.getHeaderName());
        System.out.println("Parameter Name: " + csrfToken.getParameterName());
        System.out.println("Token: " + csrfToken.getToken());
    }
}