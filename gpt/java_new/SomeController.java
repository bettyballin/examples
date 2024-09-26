import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Collection;

public class SomeController {
    public @ResponseBody SomeObject someMethodSignature(Principal principal) {
        UserDetails userDetails = null;
        Collection<? extends GrantedAuthority> authorities = null;
        
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
            authorities = userDetails.getAuthorities();
        } else if (principal instanceof Authentication) {
            Authentication authentication = (Authentication) principal;
            authorities = authentication.getAuthorities();
            Object principalObj = authentication.getPrincipal();
            if (principalObj instanceof UserDetails) {
                userDetails = (UserDetails) principalObj;
            }
        }
        
        // ... rest of the method implementation
        return new SomeObject(); // Replace with actual return
    }
}

class SomeObject {
    // Definition of SomeObject class
}