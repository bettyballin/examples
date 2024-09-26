import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class Temp1690 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1690.class, args);
    }

    @Configuration
    @EnableWebSecurity
    static class WebSecurityConfig {
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            // CSRF disabled for simplicity (not recommended in production)
            http.csrf().disable();

            // Configure authorization rules and JWT-based authentication
            http.authorizeRequests()
                    .anyRequest().authenticated()
                .and()
                    .oauth2ResourceServer().jwt();

            // OAuth2 login configuration
            http.oauth2Login()
                    .redirectionEndpoint().baseUri("/login/oauth2/code/cognito");

            return http.build();
        }
    }
}