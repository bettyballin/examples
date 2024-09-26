import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfiguration50 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs", "/webjars/**")
                .permitAll()
            .anyRequest().authenticated()
            .and()
            .addFilterBefore(new AuthenticationFilter(), BasicAuthenticationFilter.class);
    }
    
    // Assuming AuthenticationFilter is already implemented elsewhere
    private class AuthenticationFilter extends BasicAuthenticationFilter {
        public AuthenticationFilter() {
            super(null, null);
        }
    }
}