import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class Temp2529 {
    public static void main(String[] args) {
        // Application entry point
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .csrf().disable()
            .authorizeRequests((requests) -> requests
                // Allow access to login page
                .antMatchers("/login").permitAll()
                
                // Require ADMIN role for /welcome
                .antMatchers("/welcome").hasRole("ADMIN")
                
                // All other pages require authentication
                .anyRequest().authenticated())
            // Use form login
            .formLogin(login ->
                login
                    .defaultSuccessUrl("/welcome", true)
                    // Customize the default login page
                    .permitAll())
            .build();
    }
}