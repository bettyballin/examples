import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig158urerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig158 extends WebSecurityConfig158urerAdapter {

    private final AuthenticationEntryPoint entryPoint;

    public SecurityConfig158(AuthenticationEntryPoint entryPoint) {
        this.entryPoint = entryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
             .csrf().disable()
             .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/v1/users", "/v1/users/signin").permitAll()
                .anyRequest().hasAnyAuthority("ROLE_SG_ADMIN", "ROLE_O_ADMIN", "ROLE_OS_ADMIN")
                .and()
             .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}