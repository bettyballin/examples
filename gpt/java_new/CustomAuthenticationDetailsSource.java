import org.springframework.security.authentication.AuthenticationDetailsSource;
import javax.servlet.http.HttpServletRequest;

public class CustomAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, YourCustomAuthenticationDetails> {
    @Override
    public YourCustomAuthenticationDetails buildDetails(HttpServletRequest context) {
        return new YourCustomAuthenticationDetails(context);
    }
}