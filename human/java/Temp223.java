import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.ArrayList;
import java.util.List;

class User {
    private List<SimpleGrantedAuthority> authorities = new ArrayList<>();

    public List<SimpleGrantedAuthority> getAuthorities() {
        return authorities;
    }
}

public class Temp223 {
    public static void main(String[] args) {
        Temp223 temp223 = new Temp223();
        User user = new User();
        temp223.grantUserAccess(user);
        System.out.println("User authorities: " + user.getAuthorities());
    }

    public void grantUserAccess(User user) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication auth = securityContext.getAuthentication();
        user.getAuthorities().clear();
        user.getAuthorities().add(new SimpleGrantedAuthority("ROLE_AUTHORIZED_USER"));
        Authentication newAuth = new UsernamePasswordAuthenticationToken(user, auth.getCredentials(), user.getAuthorities());
        securityContext.setAuthentication(newAuth);
    }
}