import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig9urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig9 extends WebSecurityConfig9urerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .defaultSuccessUrl("/default");
    }
}