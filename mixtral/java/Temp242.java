import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp242 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // Allow anonymous access to signin and signup pages
                .antMatchers("/signin", "/panel/signin")
                    .access("hasRole('ROLE_ANONYMOUS') or hasAnyAuthority('USER', 'ADMIN')")
                .antMatchers("/signup", "/panel/signup")
                    .access("hasRole('ROLE_ANONYMOUS') or hasAnyAuthority('USER', 'ADMIN')")
                // Restrict all other URLs
                .anyRequest()
                    .authenticated();
    }

    public static void main(String[] args) {
        // Spring Boot application would start here
    }
}