import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class Temp1430 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1430.class, args);
    }

    @Bean
    public SecurityWebFilterChain webFilterChain(ServerHttpSecurity http) {
        return http.authorizeExchange(exchanges -> exchanges
                .pathMatchers("/health").permitAll()
                .anyExchange().authenticated())
            .exceptionHandling()
            .authenticationEntryPoint((exchange, exception) ->
                Mono.error(exception))
            .and()
            .csrf().disable()
            .headers().disable()
            .logout().disable()
            .requiresSecure() // Enforce HTTPS for all paths except /health
            .and()
            .build();
    }
}