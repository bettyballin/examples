import org.bouncycastle.asn1.x500.X500Name;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.authentication.x509.X509AuthenticationManager;
import org.springframework.security.web.server.authentication.x509.X509PrincipalExtractor;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.security.cert.X509Certificate;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http
                .authorizeExchange()
                .pathMatchers("/endpointA").access(this::checkCN)
                .pathMatchers("/endpointB").access(this::checkCN2)
                // other endpoints...
                .anyExchange().authenticated()
                .and()
                .addFilterAt(x509AuthenticationFilter(), SecurityWebFiltersOrder.AUTHENTICATION)
                .securityContextRepository(NoOpServerSecurityContextRepository.getInstance())
                .build();
    }

    private AuthenticationWebFilter x509AuthenticationFilter() {
        AuthenticationWebFilter filter = new AuthenticationWebFilter(x509AuthenticationManager());
        filter.setServerAuthenticationConverter(new ServerX509AuthenticationConverter());
        filter.setRequiresAuthenticationMatcher(ServerWebExchangeMatchers.anyExchange());
        filter.setSecurityContextRepository(new NoOpServerSecurityContextRepository());
        return filter;
    }

    private ReactiveAuthenticationManager x509AuthenticationManager() {
        X509AuthenticationManager manager = new X509AuthenticationManager(userDetailsService());
        manager.setPrincipalExtractor(new X509PrincipalExtractor() {
            @Override
            public Object extractPrincipal(X509Certificate certificate) {
                return certificate.getSubjectDN();
            }
        });
        return manager;
    }

    private Mono<Boolean> checkCN(ServerWebExchange exchange, Authentication authentication) {
        X500Name x500name = new X500Name(((X509Certificate)authentication.getCredentials()).getSubjectX500Principal().getName());
        return Mono.just(x500name.getCommonName().equals("client1"));
    }

    private Mono<Boolean> checkCN2(ServerWebExchange exchange, Authentication authentication) {
        X500Name x500name = new X500Name(((X509Certificate)authentication.getCredentials()).getSubjectX500Principal().getName());
        return Mono.just(x500name.getCommonName().equals("client2"));
    }

    @Bean
    public ReactiveUserDetailsService userDetailsService() {
        return username -> {
            // Implement your user loading logic here, e.g., from a database or in-memory
            return Mono.empty();
        };
    }
}