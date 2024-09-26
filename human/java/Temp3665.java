import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class Temp3665 {
    public static void main(String[] args) {
        // Your main method implementation here if needed
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .securityMatcher("/api/core/**")
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/core/**").permitAll()
                .anyRequest().authenticated()
            );
        
        return http.build();
    }

    @Bean
    public SecurityFilterChain filterChainAdditional(HttpSecurity http) throws Exception {
        http
            .securityMatcher("/api/module2/**")
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/module2/**").permitAll()
                .anyRequest().authenticated()
            );

        return http.build();
    }
}