import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class SecurityConfig40 {

    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/api/**")
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }

    private BasicAuthenticationFilter authenticationTokenFilterBean() {
        // Assuming there's a method that returns an instance of BasicAuthenticationFilter
        return new BasicAuthenticationFilter();
    }
}