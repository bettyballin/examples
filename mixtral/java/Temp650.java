import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Temp650 {

    public static void main(String[] args) {
        AuthenticationManager authenticationManager = new AuthenticationManager() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                // Dummy authentication logic
                return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials());
            }
        };

        CustomUsernamePasswordAuthenticationFilter formLogin = new CustomUsernamePasswordAuthenticationFilter("/login", authenticationManager);
    }
}

class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public CustomUsernamePasswordAuthenticationFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        super.setFilterProcessesUrl(defaultFilterProcessesUrl);
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // Custom authentication logic
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken("user", "password"));
    }
}