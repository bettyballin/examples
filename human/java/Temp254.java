import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp254 {
    public static void main(String[] args) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        CustomUser user = (CustomUser) auth.getPrincipal();
        
        // Assuming CustomUser class has a toString method or override it to print user details
        System.out.println(user);
    }
}

class CustomUser {
    private String username;

    public CustomUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "CustomUser{" +
                "username='" + username + '\'' +
                '}';
    }
}