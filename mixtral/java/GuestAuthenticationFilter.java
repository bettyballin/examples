import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

public class GuestAuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter {

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return new User("guest", "password", Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}

class User {
    private String username;
    private String password;
    private Object authorities;

    public User(String username, String password, Object authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    // getters and setters (if needed)
}