import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.logout().and()
            .antMatcher("/**").authorizeRequests()
            .antMatchers("/index.html", "/home.html", "/", "/uaa/oauth/**").permitAll()
            .anyRequest().authenticated().and()
            .csrf().csrfTokenRepository(getCSRFTokenRepository()).ignoringAntMatchers("/uaa/oauth/token").and()
            .addFilterAfter(createCSRFHeaderFilter(), CsrfFilter.class);
    }

    private CsrfTokenRepository getCSRFTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }

    private CsrfFilter createCSRFHeaderFilter() {
        return new CsrfFilter(getCSRFTokenRepository());
    }
}