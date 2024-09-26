import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Temp818 {
    public static void main(String[] args) {
        // Assuming execution context with HttpServletRequest and HttpServletResponse
        HttpServletRequest request = null; // mock request
        HttpServletResponse response = null; // mock response

        UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter() {
            @Override
            public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
                String username = obtainUsername(request);
                String password = obtainPassword(request);

                if (username == null) {
                    username = "";
                }

                if (password == null) {
                    password = "";
                }

                username = username.trim();

                UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

                // Allow subclasses to set the "details" property
                setDetails(request, authRequest);

                return this.getAuthenticationManager().authenticate(authRequest);
            }
        };

        try {
            filter.attemptAuthentication(request, response);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }
}