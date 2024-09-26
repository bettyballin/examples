import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.ServerAuthenticationEntryPoint;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import reactor.core.publisher.Mono;

@EnableReactiveMethodSecurity
@Configuration
public class SecurityConfig implements WebFluxConfigurer {

    @Bean
    public ServerAuthenticationEntryPoint authenticationEntryPoint() {
        return new JwtBearerTokenServerAuthenticationEntryPoint();
    }

    @Bean
    public ServerAccessDeniedHandler accessDeniedHandler() {
        return new JwtTokenAccessDeniedHandler();
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
            .securityMatcher(ServerWebExchangeMatchers.matchers(
                    ServerWebExchangeMatchers.pathMatchers(HttpMethod.POST, "/**"),
                    ServerWebExchangeMatchers.pathMatchers(HttpMethod.PUT, "/**"),
                    ServerWebExchangeMatchers.pathMatchers(HttpMethod.DELETE, "/**")
                )
            )
            .authorizeExchange(exchanges -> exchanges
                .pathMatchers("/docs/**", "/v2/api-docs/**", "/").permitAll()
                .pathMatchers(HttpMethod.POST).hasAuthority(PRODUCT_WRITE_SCOPE)
                .pathMatchers(HttpMethod.PUT).hasAuthority(PRODUCT_WRITE_SCOPE)
                .pathMatchers(HttpMethod.DELETE).hasAuthority(PRODUCT_WRITE_SCOPE)
                .anyExchange().authenticated()
            )
            .csrf().disable()
            .formLogin().disable()
            .oauth2ResourceServer()
            .authenticationEntryPoint(authenticationEntryPoint())
            .accessDeniedHandler(accessDeniedHandler())
            .jwt()
            .jwtAuthenticationConverter(jwt -> jwtAuthenticationConverter(jwt));

        return http.build();
    }

    private Mono<AbstractAuthenticationToken> jwtAuthenticationConverter(Jwt jwt) {
        ReactiveJwtAuthenticationConverter jwtAuthConverter = new ReactiveJwtAuthenticationConverter();
        jwtAuthConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter -> {
            JwtAuthoritiesConverter jwtAuthoritiesConverter = new JwtAuthoritiesConverter();
            ReactiveJwtGrantedAuthoritiesConverterAdapter reactiveJwtGrantedAuthoritiesConverterAdapter =
                new ReactiveJwtGrantedAuthoritiesConverterAdapter(jwtAuthoritiesConverter);
            return reactiveJwtGrantedAuthoritiesConverterAdapter.convert(jwtGrantedAuthoritiesConverter);
        });
        return jwtAuthConverter.convert(jwt);
    }

    private static final String PRODUCT_WRITE_SCOPE = "SCOPE_product:write";

}