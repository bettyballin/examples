import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfToken;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class Temp457 {
    public static void main(String[] args) {
        HttpSessionCsrfTokenRepository csrfTokenRepository = new HttpSessionCsrfTokenRepository();
        
        // Create mock request and response
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setSession(new MockHttpServletRequest().getSession()); // Add this line
        
        // Generate CSRF token
        CsrfToken csrfToken = csrfTokenRepository.generateToken(request);
        
        // Save CSRF token in the session
        csrfTokenRepository.saveToken(csrfToken, request, response);
        
        System.out.println("CSRF Token: " + csrfToken.getToken());
    }
}