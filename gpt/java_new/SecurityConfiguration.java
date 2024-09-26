import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityConfiguration {

    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/your-url").permitAll();
            // ... other configuration ...
    }

    public void checkAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            // The user is logged in
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            // ... use userDetails as needed ...
        } // else block was not closed in the original snippet
    }
}