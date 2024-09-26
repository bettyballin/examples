import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1911 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // permit all requests with the custom header "X-Operation-Name=forgot-password"
                .requestMatchers(req -> req.getMethod().equals("POST") &&
                                        "/api/website-user".equals(req.getRequestURI()) &&
                                        "forgot-password".equals(req.getHeader("X-Operation-Name")))
                    .permitAll()
                // permit all other requests with authentication
                .anyRequest().authenticated();
    }

    public static void main(String[] args) {
        System.out.println("Spring Security configuration loaded.");
    }
}