import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;

@EnableWebSecurity
public class WebSecurityConfig3 {

    public void configure(HttpSecurity http) throws Exception {
        FormLoginConfigurer<HttpSecurity> formLogin = new FormLoginConfigurer<>();
        http.apply(formLogin);
        formLogin.loginPage("/auth/login").permitAll();
    }
}