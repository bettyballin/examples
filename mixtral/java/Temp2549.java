import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class Temp2549 {
    public static void main(String[] args) {
        // This main method can be used to run the Spring application if needed
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().ignoringRequestMatchers("/design", "/orders").and()
            // Add additional security configurations here
            .authorizeRequests()
            .anyRequest().authenticated();
        return http.build();
    }
}