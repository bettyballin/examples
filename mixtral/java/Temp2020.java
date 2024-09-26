import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.authentication.AuthenticationProvider;

public class Temp2020 {
    public static void main(String[] args) {
        System.out.println("Spring Security Configuration Example");
    }
}

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final AuthenticationProvider authenticationProvider;

    public SecurityConfig(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .authenticationProvider(authenticationProvider)
            .authorizeRequests()
                // More specific rule
                .antMatchers("/api/v1/specific").hasRole("ONLY_FOR_THIS_ENDPOINT")
                // Broader rule
                .anyRequest().authenticated();
    }
}