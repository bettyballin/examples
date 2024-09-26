import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

public class Temp2417 {
    public static void main(String[] args) {
        System.out.println("Application started.");
    }
}

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationEntryPoint customAuthEntryPoint;

    public SecurityConfig(AuthenticationEntryPoint customAuthEntryPoint) {
        this.customAuthEntryPoint = customAuthEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // other config here
        http.oauth2ResourceServer().jwt()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(customAuthEntryPoint);
    }
}