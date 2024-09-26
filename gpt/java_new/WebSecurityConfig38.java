import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig38urerAdapter;
import org.springframework.security.access.AccessDecisionManager;

@EnableWebSecurity
public class WebSecurityConfig38 extends WebSecurityConfig38urerAdapter {

    private AccessDecisionManager accessDecisionManager;

    public WebSecurityConfig38(AccessDecisionManager accessDecisionManager) {
        this.accessDecisionManager = accessDecisionManager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/authentication/login**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accessDenied")
                .and()
                // Other configurations such as formLogin, httpBasic, csrf, etc.
                .httpBasic();
    }
}