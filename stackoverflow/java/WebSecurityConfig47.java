import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig47urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig47 extends WebSecurityConfig47urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin(form -> form
                .loginPage("/index?showDialog=true")
            );
    }
}