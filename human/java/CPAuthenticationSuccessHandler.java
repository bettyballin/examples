import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CPAuthenticationSuccessHandler extends DCAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, 
                                        Authentication authentication) {
        // Do anything that you want to do here. Any changes to the HttpServletResponse
        // will be overwritten when you call super. So when you call super will
        // depend on what logic you want to implement.

        super.onAuthenticationSuccess(request, response, authentication);
    }
}

// Assuming the existence of the following DCAuthenticationSuccessHandler class
class DCAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, 
                                        Authentication authentication) {
        // Default implementation of onAuthenticationSuccess
        System.out.println("Authentication was successful!");
    }
}