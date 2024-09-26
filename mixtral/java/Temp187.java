import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

public class Temp187 {
    public static void main(String[] args) {
        // Example usage
        // Authentication authentication = ...; // obtain an authentication object
        // someMethodSignature(authentication);
    }

    public @ResponseBody SomeObject someMethodSignature(Authentication authentication) {
        // Get user details
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();

            Collection<? extends GrantedAuthority> authorities
                = ((UserDetails) principal).getAuthorities();

            // Do something with the user details and their permissions
        }
        return new SomeObject(); // Return some object as required by the method signature
    }

    static class SomeObject {
        // Define fields, constructors, and methods for SomeObject
    }
}