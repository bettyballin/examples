import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component("failureHandler")
public class LoginFailureHandler implements AuthenticationFailureHandler {

    private SimpleUrlAuthenticationFailureHandler delegate = new SimpleUrlAuthenticationFailureHandler();

    @Override
    public void onAuthenticationFailure(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, org.springframework.security.core.AuthenticationException exception) throws java.io.IOException, javax.servlet.ServletException {
        delegate.onAuthenticationFailure(request, response, exception);
    }
}