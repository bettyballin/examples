import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;

@Bean
public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    AuthenticationWebFilter authenticationFilter = new AuthenticationWebFilter(authenticationManagerResolver);
    authenticationFilter.setServerAuthenticationConverter(new CustomTokenAuthenticationConverter());

    return http
            .addFilterBefore(authenticationFilter, OAuth2ResourceServerFilter.class)
            .oauth2ResourceServer()
                .authenticationManagerResolver(authenticationManagerResolver)
            .and()
            .build();
}

@Bean
public AuthenticationManagerResolver<ServerHttpRequest> authenticationManagerResolver() {
    // Provide implementation for the authentication manager resolver
    return request -> Mono.just(authentication -> {
        // Authentication logic
        return Mono.empty();
    });
}

class CustomTokenAuthenticationConverter implements ServerAuthenticationConverter {
    @Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {
        // Custom token conversion logic
        return Mono.empty();
    }
}

class CustomTokenAuthenticationFilter extends AuthenticationWebFilter {
    public CustomTokenAuthenticationFilter(AuthenticationManagerResolver<ServerHttpRequest> authenticationManagerResolver) {
        super(authenticationManagerResolver);
    }
}