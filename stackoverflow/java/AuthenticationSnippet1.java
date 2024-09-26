import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

public class AuthenticationSnippet1 {
    public void authenticateUser(Object principal, Collection<? extends GrantedAuthority> authorities, HttpServletRequest context) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(principal, null, authorities);
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(context));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}