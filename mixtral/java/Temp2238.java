Here's the complete executable Java code:


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // Your other configurations here
            .csrf().disable();
    }

    public static String getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            return "";
        }

        Object principal = authentication.getPrincipal();

        // If the principal is a string it's an anonymous user
        if (principal instanceof String && ((String) principal).equals("anonymousUser")) {
            return "Anonymous User";
        }

        return principal.toString();
    }
}