import org.springframework.security.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomAuthenticationFilter1 extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        String emailToken = request.getParameter("emailToken");
        request.setAttribute("emailToken", emailToken);
        return super.attemptAuthentication(request, response);
    }
}

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

public class CustomAuthenticationProvider extends DaoAuthenticationProvider {
    // Implementation of CustomAuthenticationProvider
}