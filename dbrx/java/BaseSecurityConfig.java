import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.web.server.WebFilter;

import org.springframework.http.HttpMethod;

@Configuration
@EnableWebFluxSecurity
public abstract class BaseSecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http.csrf().disable()
                .authorizeExchange()
                .anyExchange().authenticated()
                .and()
                .build();
    }
}

@Configuration
@EnableWebFluxSecurity
public class ServiceAConfig extends BaseSecurityConfig {

    @Bean
    @Override
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .securityMatcher(ServerWebExchangeMatchers.pathMatchers("/api/serviceA/**"))
                .authorizeExchange()
                .pathMatchers(HttpMethod.GET, "/api/serviceA/**")
                .hasAuthority("PROP_A")
                .anyExchange().authenticated()
                .and()
                .build();
    }
}

@Configuration
@EnableWebFluxSecurity
public class ServiceBConfig extends BaseSecurityConfig {

    @Bean
    @Override
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .securityMatcher(ServerWebExchangeMatchers.pathMatchers("/api/serviceB/**"))
                .authorizeExchange()
                .pathMatchers(HttpMethod.GET, "/api/serviceB/**")
                .hasAuthority("PROP_B")
                .anyExchange().authenticated()
                .and()
                .build();
    }
}