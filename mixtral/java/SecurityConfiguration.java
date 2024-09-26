import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String LOGIN_URL = "/login";
    private static final String LOGIN_PROCESSING_URL = "/login/process";
    private static final String LOGIN_FAILURE_URL = "/login?error=true";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
                .requestCache().requestCache(new CustomRequestCache())
                    .and()
                .authorizeRequests()
                    .antMatchers("/FormClient").permitAll() // Correct method call
                    .anyRequest().authenticated()
            .and()
                .formLogin()
                    .loginPage(LOGIN_URL).permitAll()
                    .loginProcessingUrl(LOGIN_PROCESSING_URL)
                    .failureUrl(LOGIN_FAILURE_URL);
    }
}

class CustomRequestCache extends org.springframework.security.web.savedrequest.HttpSessionRequestCache {
    // Custom implementation if needed
}