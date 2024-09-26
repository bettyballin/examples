import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class Temp2496 {

    public static void main(String[] args) {
        SpringApplication.run(Temp2496.class, args);
    }

    @Bean
    @Order(0)
    public SecurityFilterChain swaggerFilterChain(HttpSecurity http) throws Exception {
        // Configure the HttpSecurity for swagger endpoints
        http
            .antMatcher("/swagger/**")
            .authorizeRequests(authorize -> authorize
                .anyRequest().permitAll()
            );
        return http.build();
    }

    @Bean
    @Order(1)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Configure the HttpSecurity for other endpoints
        http
            .authorizeRequests(authorize -> authorize
                .anyRequest().authenticated()
            )
            .formLogin(withDefaults());
        return http.build();
    }
}