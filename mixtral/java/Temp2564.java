import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@SpringBootApplication
public class Temp2564 {

    public static void main(String[] args) {
        SpringApplication.run(Temp2564.class, args);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .cors().and()
            .csrf().disable()
            .authorizeRequests((authz) -> authz
                // your authorization rules
            )
            .exceptionHandling((exceptions) -> exceptions
                .accessDeniedHandler(new CustomAccessDeniedHandler())
            ).build();
    }

    // Define CustomAccessDeniedHandler class
    public class CustomAccessDeniedHandler implements AccessDeniedHandler {
        @Override
        public void handle(javax.servlet.http.HttpServletRequest request,
                           javax.servlet.http.HttpServletResponse response,
                           org.springframework.security.access.AccessDeniedException accessDeniedException)
                throws java.io.IOException, javax.servlet.ServletException {
            // Custom handling code
            response.sendError(javax.servlet.http.HttpServletResponse.SC_FORBIDDEN, "Access Denied!");
        }
    }
}