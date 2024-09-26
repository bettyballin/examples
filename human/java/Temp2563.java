import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

public class Temp2563 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // The main method can be empty or used to run a Spring application
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http.
            authorizeRequests().
                antMatchers("/ping", "/actuator/health", "/actuator/info", "/login").permitAll().
                anyRequest().authenticated().and().
            httpBasic().and().
            // CSRF tokens for API access
            csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        // @formatter:on
    }
}