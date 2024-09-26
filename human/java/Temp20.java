import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.List;

public class Temp20 {
    public static void main(String[] args) {
        Temp20 temp20 = new Temp20();
        boolean currentUserIsAuthor = true; // Example boolean, replace with actual logic

        // Assuming modelAndView is a valid ModelAndView object
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.addObject("canEditPost", 
            Boolean.valueOf(currentUserIsAuthor || temp20.isAdmin())
        );
    }

    private boolean isAdmin() {
        Authentication currentAuthObj = SecurityContextHolder.getContext().getAuthentication();
        List<GrantedAuthority> authorities = Arrays.asList(currentAuthObj.getAuthorities().toArray(new GrantedAuthority[0]));
        for (GrantedAuthority auth : authorities) {
            if ("ROLE_ADMIN".equals(auth.getAuthority())) {
                return true;
            }
        }
        return false;
    }
}

// Assuming ModelAndView class for demonstration
class ModelAndView {
    public void addObject(String key, Boolean value) {
        // Implementation for adding object
        System.out.println("Added: " + key + " = " + value);
    }
}