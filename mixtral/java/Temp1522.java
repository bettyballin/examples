import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;

import java.util.Collection;

public class Temp1522 {
    public static void main(String[] args) {
        // This main method is just a placeholder and does not execute the showDashboard method.
    }

    public String showDashboard(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Access the required data
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;

            String username = userDetails.getUsername();

            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

            // Additional logic for handling authorities if needed
        }

        return "dashboard";
    }
}