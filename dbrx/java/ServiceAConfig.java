import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;

@Configuration
@EnableWebFluxSecurity
public class ServiceAConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChainA(ServerHttpSecurity http) {
        http.securityMatcher(ServerWebExchangeMatchers.pathMatchers("/api/serviceA/**"))
                .authorizeExchange()
                    .pathMatchers(HttpMethod.GET, "/api/serviceA/**")
                        .hasAuthority("PROP_A")
                    .anyExchange().authenticated();
        return http.build();
    }
}

@Configuration
@EnableWebFluxSecurity
public class ServiceBConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChainB(ServerHttpSecurity http) {
        http.securityMatcher(ServerWebExchangeMatchers.pathMatchers("/api/serviceB/**"))
                .authorizeExchange()
                    .pathMatchers(HttpMethod.GET, "/api/serviceB/**")
                        .hasAuthority("PROP_B")
                    .anyExchange().authenticated();
        return http.build();
    }
}