import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfiguration34 {

    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(HttpMethod.POST, "/users/login");
    }
}