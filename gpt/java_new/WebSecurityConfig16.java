import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig16urerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

@EnableWebSecurity
public class WebSecurityConfig16 extends WebSecurityConfig16urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... your other configurations
            .csrf().requireCsrfProtectionMatcher(new RequestMatcher() {
                @Override
                public boolean matches(HttpServletRequest request) {
                    String nonBrowserHeader = request.getHeader("X-Requested-With");
                    return nonBrowserHeader == null || !nonBrowserHeader.equals("NonBrowserClient");
                }
            })
            // ... other configurations
            ;
    }
}