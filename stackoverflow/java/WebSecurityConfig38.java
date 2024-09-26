import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.stereotype.Component;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Component
@EnableWebSecurity
public class WebSecurityConfig38 {

    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/foo-url");
    }
}