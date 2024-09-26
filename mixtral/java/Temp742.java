import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class Temp742 {
    public static void main(String[] args) {

        List<SimpleGrantedAuthority> updatedRoles = new ArrayList<>();
        updatedRoles.add(new SimpleGrantedAuthority("ROLE_STEPONE"));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if authentication is not null to avoid NullPointerException
        if (authentication != null) {
            // Update roles
            authentication.setAuthenticated(true);
            List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
            authorities.clear();
            authorities.addAll(updatedRoles);

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }
}