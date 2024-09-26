import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import my.package.JWTAuthenticationFilter; // Replace with your filter's package

public class SecurityConfig87 {

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .addFilterAfter(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}