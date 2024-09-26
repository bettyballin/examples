import org.springframework.security.web.csrf.CsrfToken;

import javax.servlet.http.HttpServletRequest;

public class Temp1001 {
    public static void main(String[] args) {
        HttpServletRequest request = null; // Placeholder for actual request
        
        // Simulate request attribute for demonstration purposes
        CsrfToken csrf = (CsrfToken) request.getAttribute("_csrf");
        String tokenValue = csrf != null ? csrf.getToken() : "";

        // Output the token value (for demonstration purposes)
        System.out.println("CSRF Token: " + tokenValue);
    }
}