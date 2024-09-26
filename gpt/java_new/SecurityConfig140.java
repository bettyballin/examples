import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig140urerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.http.HttpMethod;

public class SecurityConfig140 extends WebSecurityConfig140urerAdapter {

    private AccessDeniedHandler accessDeniedHandler;

    // Assume a constructor or a setter method to inject accessDeniedHandler

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/", "/orders").permitAll()
            .antMatchers(HttpMethod.POST, "/order/**").hasAnyRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "/order/**").hasAnyRole("ADMIN")
            .and()
            .httpBasic()
            .and()
            .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }
}