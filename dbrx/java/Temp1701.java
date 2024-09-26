import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

@SpringBootApplication
@EnableWebSecurity
public class Temp1701 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Temp1701.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
            .authenticationEntryPoint(customAuthenticationEntryPoint());
    }

    @Bean
    public AuthenticationEntryPoint customAuthenticationEntryPoint() {
        return new YourCustomAuthenticationEntryPoint();
    }
}

class YourCustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(
        javax.servlet.http.HttpServletRequest request,
        javax.servlet.http.HttpServletResponse response,
        org.springframework.security.core.AuthenticationException authException
    ) throws java.io.IOException, javax.servlet.ServletException {
        response.sendError(javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}