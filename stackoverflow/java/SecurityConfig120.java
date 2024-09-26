import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.http.HttpMethod;

public class SecurityConfig120 {

    public void configure(HttpSecurity http) throws Exception {
        http.csrf()
            .disable()
            .httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET,"/registration")
            .permitAll()
            .anyRequest()
            .authenticated();
    }
}