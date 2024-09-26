import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@SpringBootApplication
public class Temp2168 {

    public static void main(String[] args) {
        SpringApplication.run(Temp2168.class, args);
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .headers().frameOptions().disable()
                .and()
                .csrf().disable() // Disable CSRF protection
                .authorizeExchange()
                .anyExchange().authenticated()
                .and()
                .formLogin()
                .build();
    }
}