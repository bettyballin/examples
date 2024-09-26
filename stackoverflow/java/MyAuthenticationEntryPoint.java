import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
        throws IOException, ServletException {
        if (authEx.getCause() instanceof TransactionException) {
            response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, authEx.getMessage());
        } else {
            response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authEx.getMessage());
        }
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("test");
        super.afterPropertiesSet();
    }
}