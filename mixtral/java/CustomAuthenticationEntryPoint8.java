import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        if (authException instanceof BadCredentialsException ||
            authException instanceof UsernameNotFoundException) {
            
            // Handle 401 Unauthorized
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        
        } else {
            
            // Handle other authentication exceptions
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}