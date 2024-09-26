import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import java.util.Collections;

class User {
    public Object getAuthorities() {
        return Collections.emptyList(); // Placeholder for user authorities, modify as needed
    }
}

public class Temp282 {
    public static void main(String[] args) {
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
        User localeUser = new User();
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(localeUser, null, localeUser.getAuthorities());
        
        // ... rest of your code

    }
}