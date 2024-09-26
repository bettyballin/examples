import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests((requests) -> requests
                // Allow unauthenticated access to GET /users
                .antMatchers("/users").permitAll()

                // Require authentication for all other endpoints
                .anyRequest().authenticated())

        // Enable HTTP Basic Authentication
            .httpBasic(withDefaults());

        return http.build();
    }
}