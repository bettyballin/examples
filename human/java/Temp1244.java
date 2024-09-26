import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.DefaultRedirectStrategy;

public class Temp1244 extends SimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public static void main(String[] args) {
        // This main method can be used to test the class, 
        // but as it's a Spring Security handler, it won't be invoked in a standard Java application.
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, 
      HttpServletResponse response, Authentication authentication) throws IOException {
        //Your custom stuff
        handle(request, response, authentication);
    }

    protected void handle(HttpServletRequest request, 
        HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = "";//Place your target url detection logic here. 

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
}