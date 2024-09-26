import org.springframework.stereotype.Component;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyAuthenticationFilter1 extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authToken;

        if ("user".equals(request.getParameter("userType"))) {
            authToken = new UsernamePasswordAuthenticationToken(
                request.getParameter("userName"), 
                request.getParameter("password")
            );
        } else {
            authToken = new UsernamePasswordAuthenticationToken(
                request.getParameter("userName"), 
                request.getParameter("password")
            );
            // Note: The original code had custom token classes `UserUsernamePasswordAuthenticationToken`
            // and `AdminUsernamePasswordAuthenticationToken` which are not standard and not provided
            // in the snippet. They need to be implemented separately if they have special behavior.
        }

        setDetails(request, authToken);

        return this.getAuthenticationManager().authenticate(authToken);
    }
}