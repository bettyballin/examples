import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authToken;

        if ("user".equals(request.getParameter("userType"))) {
            authToken = new UsernamePasswordAuthenticationToken(request.getParameter("userName"), request.getParameter("password"));
        } else {
            authToken = new UsernamePasswordAuthenticationToken(request.getParameter("userName"), request.getParameter("password"));
        }

        setDetails(request, authToken);

        return super.getAuthenticationManager().authenticate(authToken);
    }
}