import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp816 extends WebSecurityConfigurerAdapter {

    private static final String API_ROLE = "API";

    public static void main(String[] args) {
        // Main method can be used for launching Spring context if needed
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/services/**")
                .authorizeRequests()
                    .anyRequest().hasRole(API_ROLE)
                .and()
            .httpBasic()
                .and()
            .csrf()
                .disable();
    }
}