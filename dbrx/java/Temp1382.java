import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
public class Temp1382 extends WebSecurityConfigurerAdapter {

    private final AuthenticationSuccessHandler customAuthenticationSuccessHandler;

    public Temp1382(AuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .successHandler(customAuthenticationSuccessHandler)
                .permitAll();
    }

    public static void main(String[] args) {
        // Spring Boot application would typically start here
        // SpringApplication.run(Temp1382.class, args);
    }
}