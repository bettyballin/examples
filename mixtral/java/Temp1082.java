import org.springframework.security.web.csrf.CsrfTokenRequestHandler;
import org.springframework.security.web.csrf.DefaultCsrfTokenRequestAttributeHandler;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
                // Use this if sending X-XSRF-TOKEN header
                .csrfTokenRequestHandler(new DefaultCsrfTokenRequestAttributeHandler())

                // Or use this if using cookie
                .and().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and().addFilterAfter(
                    new CsrfFilter(CookieCsrfTokenRepository.withHttpOnlyFalse()),
                    AbstractAuthenticationProcessingFilter.class
                );
    }
}