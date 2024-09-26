import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private AuthenticationSuccessHandler authSuccessHandler;

    public TokenAuthenticationFilter(String defaultFilterProcessesUrl, AuthenticationSuccessHandler authSuccessHandler) {
        super(defaultFilterProcessesUrl);
        this.authSuccessHandler = authSuccessHandler;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authentication)
            throws IOException, ServletException {

        this.authSuccessHandler.onAuthenticationSuccess(request, response, authentication);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Implement your logic to attempt authentication here
        return null;
    }
}