import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationFilter;
import org.springframework.security.oauth2.server.resource.BearerTokenAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomBearerTokenAuthenticationFilter extends BearerTokenAuthenticationFilter {

    private static final Logger log = LoggerFactory.getLogger(CustomBearerTokenAuthenticationFilter.class);

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);

        // Add your logging statements here
        if (failed instanceof BearerTokenAuthenticationException) {
            log.error("Invalid bearer token: {}", ((BearerTokenAuthenticationException) failed).getToken());
        } else {
            log.error("Authentication failed: {}", failed.getMessage());
        }
    }
}