import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class KerberosFailureHandler implements AuthenticationFailureHandler {

    private String loginPageUrl;

    public KerberosFailureHandler(final AuthenticationEntryPoint authenticationEntryPoint) throws Exception {
        if (authenticationEntryPoint instanceof HttpStatusEntryPoint) {
            this.loginPageUrl = ((HttpStatusEntryPoint) authenticationEntryPoint).getPath();
        } else {
            throw new IllegalArgumentException("Invalid entry point type");
        }
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException exception) throws IOException, ServletException {
        response.sendRedirect(loginPageUrl);
    }

}