import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig74urerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
public class WebSecurityConfig74 extends WebSecurityConfig74urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
                .requireCsrfProtectionMatcher(request -> {
                    String clientType = request.getHeader("X-Client-Type");
                    boolean isBrowser = clientType == null || !"non-browser".equals(clientType);
                    return isBrowser && "POST".equals(request.getMethod());
                })
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            .and()
                .authorizeRequests()
                .anyRequest().authenticated();
    }
}