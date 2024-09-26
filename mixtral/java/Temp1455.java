import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collections;

public class Temp1455 {
    public static void main(String[] args) {

        // Create a dummy user and authorities
        String user = "dummyUser";
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, Collections.singletonList(authority));

        // Set the context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        try {
            // Invoke method
            System.out.println("Authenticated user: " + SecurityContextHolder.getContext().getAuthentication().getName());
        } finally {
            SecurityContextHolder.clearContext();
        }
    }
}