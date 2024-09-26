import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp695 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method content if needed
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/api/login", "/api/logout").permitAll() // Allow these endpoints without authentication
                .antMatchers("/api/**").authenticated() // Require all other /api/ endpoints to be authenticated
                .anyRequest().authenticated();
    }
}