import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfiguration29 {

    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/services/rest/registerUser");
    }
}