import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class Temp2483 {
    public static void main(String[] args) {
        SpringApplication.run(Temp2483.class, args);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeRequests((requests) -> requests
                // allow anonymous access to public resources
                .antMatchers("/", "/login**").permitAll()
                // require authentication for all other pages
                .anyRequest().authenticated())
            .formLogin(
                 form ->
                      form
                    .defaultSuccessUrl("/dashboard")
                    .failureForwardUrl("/error"))
             .build();
    }
}