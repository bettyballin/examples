import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class Temp1172 {

    public static void main(String[] args) {
        // This main method is not needed for a Spring Boot application
        // Spring Boot will automatically handle web requests and security
    }

    @RequestMapping("/")
    @ResponseBody
    public String checkRole() {
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        boolean isUser = authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"));
        boolean isAdmin = authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        boolean isSuperUser = authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_SADMIN"));

        if (isSuperUser) {
            return "You're a superadmin";
        } else if (isAdmin) {
            return "You're an admin";
        } else if (isUser) {
            return "You're a user";
        } else {
            return "You have no relevant role";
        }
    }
}