import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests((requests) -> requests
                .antMatchers("/generate/**", "/validate/**").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterAfter(new TokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // Example Filter class (Replace with your actual implementation)
    public class TokenAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
        // Implement your filter logic here
    }
}