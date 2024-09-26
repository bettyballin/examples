import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp995 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Application started");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // Your security configuration goes here
            .authorizeRequests()
                .anyRequest().authenticated()
            .and()
            .exceptionHandling()
                .authenticationEntryPoint(new CustomAuthExceptionHandler());
    }

    // Your CustomAuthExceptionHandler class definition
    private static class CustomAuthExceptionHandler implements org.springframework.security.web.AuthenticationEntryPoint {
        @Override
        public void commence(
            javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response,
            org.springframework.security.core.AuthenticationException authException
        ) throws java.io.IOException, javax.servlet.ServletException {
            response.sendError(javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        }
    }
}