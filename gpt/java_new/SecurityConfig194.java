import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfig194 {

    @Bean
    @Order(1)
    public SecurityWebFilterChain sdkJsWebFilterChain(ServerHttpSecurity http) {
        return http
            .authorizeExchange(exchanges -> exchanges
                .pathMatchers(HttpMethod.OPTIONS, "/admin/**").permitAll()
                .pathMatchers("/admin/**").authenticated()
            )
            .httpBasic().and()
            .csrf().disable()
            .build();
    }
}