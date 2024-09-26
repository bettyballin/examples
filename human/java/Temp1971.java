import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.session.SessionManagementFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers()
            .frameOptions().sameOrigin()
        .and().formLogin()
            .loginPage("/login")
            .failureHandler(failureHandler())
            .successForwardUrl("/")
            .permitAll()
            .loginProcessingUrl("/login")
        .and().logout()
            .logoutSuccessUrl("/login?logout")
        .and().authorizeRequests()
            .antMatchers("/login").permitAll()
            .antMatchers("/change-password").permitAll()
            .anyRequest().authenticated()
        .and().csrf()
            .csrfTokenRepository(csrfTokenRepository())
        .and().addFilterAfter(csrfHeaderFilter(), SessionManagementFilter.class);
    }

    private CustomAuthenticationFailureHandler failureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    private CsrfTokenRepository csrfTokenRepository() {
        return new CustomCsrfTokenRepository();
    }

    private CsrfFilter csrfHeaderFilter() {
        return new CsrfFilter(csrfTokenRepository());
    }
}

class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    // Implement the handler logic here
}

class CustomCsrfTokenRepository implements CsrfTokenRepository {
    // Implement the repository logic here
}