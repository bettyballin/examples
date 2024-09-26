import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler3 implements AuthenticationSuccessHandler {
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        String ip = request.getRemoteAddr();
        String browserInfo = request.getHeader("User-Agent");
        String requestedPage = request.getRequestURI();
        
        // Now you can store these details to the database as per your requirements.
        saveLoginDetails(ip, browserInfo, requestedPage, authentication);
        
        // Redirect or forward to the default target URL
        response.sendRedirect("/defaultTargetUrl");
    }
    
    private void saveLoginDetails(String ip, String browserInfo, String requestedPage, Authentication authentication) {
        // Implement the logic to store the login details
    }
}