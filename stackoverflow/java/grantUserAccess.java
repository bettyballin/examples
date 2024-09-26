import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public void grantUserAccess(User user) {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    Authentication auth = securityContext.getAuthentication();
    user.getAuthorities().clear();
    user.getAuthorities().add(new SimpleGrantedAuthority("ROLE_AUTHORIZED_USER"));
    Authentication newAuth = new UsernamePasswordAuthenticationToken(
        user, auth.getCredentials(), user.getAuthorities());
    securityContext.setAuthentication(newAuth);
}