import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

public class SecurityConfig20 {
    void configure(HttpSecurity http) throws Exception {
        http
          .httpBasic().and()
          .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/employees").hasRole("ADMIN")
            .antMatchers(HttpMethod.PUT, "/employees/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.PATCH, "/employees/**").hasRole("ADMIN");
    }
}