import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class OTPAuthorizationFilter extends AbstractAuthenticationProcessingFilter {

    public OTPAuthorizationFilter() {
        super("/otp_login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String otp = request.getParameter("otp");

        if (username == null || password == null || otp == null) {
            throw new AuthenticationException("Missing authentication parameters") {};
        }

        return new OTPAuthorizationToken(username, password, otp);
    }

    // Assuming OTPAuthorizationToken class exists and extends AbstractAuthenticationToken
    // You would need to implement the OTPAuthorizationToken class accordingly
}