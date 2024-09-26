import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration53 {

    // ... your existing configuration

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
            .authorizeExchange(exchanges -> exchanges
                .pathMatchers("/api/rest/**").authenticated()
                .anyExchange().permitAll()
            )
            .httpBasic().authenticationEntryPoint((exchange, e) -> exchange.getResponse().setComplete())
            .and()
            .exceptionHandling()
            .authenticationEntryPoint((exchange, e) -> exchange.getResponse().setComplete());
        return http.build();
    }
}