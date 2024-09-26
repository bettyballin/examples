import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

@SpringBootApplication
public class Temp433 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Temp433.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint());
    }

    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint("/login");
    }
}

class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final String loginUrl;

    public CustomAuthenticationEntryPoint(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    @Override
    public void commence(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response,
                         org.springframework.security.core.AuthenticationException authException)
            throws java.io.IOException, javax.servlet.ServletException {
        response.sendRedirect(loginUrl);
    }
}