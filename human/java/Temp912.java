import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;

public class Temp912 {

    public static void main(String[] args) {
        // Simulate a user with ROLE_ADMIN authority
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                "admin", "password", Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))
        );
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);

        Temp912 temp = new Temp912();
        temp.sampleMethod(new Object());
    }

    @PreAuthorize("hasPermission(#entity, 'ADMINISTRATION') or hasRole('ROLE_ADMIN')")
    public void sampleMethod(Object entity) {
        System.out.println("Method executed successfully");
    }
}