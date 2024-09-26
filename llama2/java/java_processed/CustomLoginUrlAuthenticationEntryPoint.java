import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
    private UserDetailsService userDetailsService;

    public CustomLoginUrlAuthenticationEntryPoint(String loginFormUrl, UserDetailsService userDetailsService) {
        super(loginFormUrl);
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void handleSpringSecurityException(AuthenticationException e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Custom handling code here
    }
}