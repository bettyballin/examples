import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Temp698 implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        String targetUrl = "/welcome/" + authentication.getName();
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    private org.springframework.security.web.RedirectStrategy redirectStrategy = new org.springframework.security.web.DefaultRedirectStrategy();

    protected org.springframework.security.web.RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    public void setRedirectStrategy(org.springframework.security.web.RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    public static void main(String[] args) {
        // This main method can be used to test other parts of the code
    }
}