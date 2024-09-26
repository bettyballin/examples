import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

public class Temp3577 {
    public static void main(String[] args) {
        Object principal = "user";
        Object credentials = null;
        var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        HttpServletRequest context = null; // This should be a real request object in a real application

        var authentication = new UsernamePasswordAuthenticationToken(principal, credentials, authorities);
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(context));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        System.out.println("Authentication set: " + SecurityContextHolder.getContext().getAuthentication());
    }
}