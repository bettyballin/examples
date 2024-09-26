import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Component
public class CustomAuthorityProvider implements org.springframework.security.access.prepost.AuthorityProvider {

    private static final String ROLE_PREFIX = "ROLE_";

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public List<GrantedAuthority> getAuthorities(Principal principal) {
        User user = (User) userDetailsService.loadUserByUsername(principal.getName());
        return user.getAuthorities();
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    @Override
    public GrantedAuthority getAuthority(String authority) {
        if (authority.startsWith(ROLE_PREFIX)) {
            String role = authority.substring(ROLE_PREFIX.length());

            Principal principal = SecurityContextHolder.getContext().getAuthentication();
            User user = (User) userDetailsService.loadUserByUsername(principal.getName());

            if (user != null) {
                List<GrantedAuthority> authorities = user.getAuthorities();

                for (GrantedAuthority grantedAuthority : authorities) {
                    if (grantedAuthority.getAuthority().equals(role)) {
                        return grantedAuthority;
                    }
                }
            }
        }

        return null;
    }
}