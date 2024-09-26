import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class YourClass7 {

    public String checkAuthority() {
        boolean hasAuthorityAdmin = false;
    
        hasAuthorityAdmin = SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
        if (hasAuthorityAdmin) {
            return "redirect:/admin/";
        }
        return "redirect:/user/";
    }
}