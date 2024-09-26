import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.DefaultRedirectStrategy;

public class Temp1728 implements AuthenticationSuccessHandler {

    public static void main(String[] args) {
        // This main method is just a placeholder and won't execute the authentication logic.
        System.out.println("Temp1728 class is ready to be used as AuthenticationSuccessHandler.");
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, 
                                        HttpServletResponse httpServletResponse, 
                                        Authentication authentication) throws IOException, ServletException {
        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, 
            "/welcome/" + authentication.getName());
    }
}