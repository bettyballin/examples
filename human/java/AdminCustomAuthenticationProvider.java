import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminCustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (username.equals("admin") && password.equals("admin@123#")) {
            List<GrantedAuthority> authorityList = new ArrayList<>();
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
            authorityList.add(authority);

            return new AdminUsernamePasswordAuthenticationToken(username, password, authorityList);
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(AdminUsernamePasswordAuthenticationToken.class);
    }
}

class AdminUsernamePasswordAuthenticationToken extends org.springframework.security.authentication.UsernamePasswordAuthenticationToken {

    public AdminUsernamePasswordAuthenticationToken(Object principal, Object credentials, List<GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}