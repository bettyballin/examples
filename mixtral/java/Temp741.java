import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.Collection;

public class Temp741 {
    public static void main(String[] args) {

        // Create Authentication Token
        String username = "user@example.com";
        Object principal = username; // Replace with your custom UserDetails object if needed
        Collection<? extends GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        Authentication authentication = new UsernamePasswordAuthenticationToken(principal, null, authorities);

        // Set Authentication to SecurityContextHolder
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);

        // Update the security context
        SecurityContextHolder.setContext(context);
        
        // Verify the context
        Authentication currentAuth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Authenticated User: " + currentAuth.getName());
        System.out.println("Authorities: " + currentAuth.getAuthorities());
    }
}


To run this code, ensure you have the necessary Spring Security dependencies in your project.