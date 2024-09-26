import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.server.authentication.logout.ServerLogoutHandler;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;

public class Temp1893 {
    public static void main(String[] args) {
        // Assuming this is being called within a configuration method or similar context
        // where 'http' is an instance of a security configuration class.

        // Example placeholder for the security configuration context
        SecurityConfiguration http = new SecurityConfiguration();

        http.logout()
            // Disable default LogoutPageGeneratingWebFilter
            .disableDefaultLogoutHandling()

            // Add your custom handler
            .addLogoutHandler(new ServerLogoutHandler() {
                @Override
                public Mono<Void> logout(org.springframework.security.core.Authentication authentication, org.springframework.web.server.WebFilterExchange exchange) {
                    // Custom logout handler logic
                    return Mono.empty();
                }
            })

            // Configure logout success handling
            .logoutSuccessHandler((exchange, authentication) -> {
                exchange.getExchange().getResponse().setStatusCode(HttpStatus.FOUND);

                URI location = UriComponentsBuilder
                    .fromUriString("/after-life")
                    .build()
                    .toUri();

                exchange.getExchange().getResponse().getHeaders().setLocation(location);
                return Mono.empty();
            })

            // Configure logout request matcher
            .requireLogout(new ServerWebExchangeMatcher() {
                @Override
                public Mono<MatchResult> matches(org.springframework.web.server.ServerWebExchange exchange) {
                    if (exchange.getRequest().getPath().value().equals("/logout") &&
                            exchange.getRequest().getMethod() == HttpMethod.GET) {
                        return MatchResult.match();
                    }
                    return MatchResult.notMatch();
                }
            });
    }
}

// Placeholder class to simulate security configuration context
class SecurityConfiguration {
    public SecurityConfiguration logout() {
        // Placeholder for actual logout configuration
        return this;
    }

    public SecurityConfiguration disableDefaultLogoutHandling() {
        // Placeholder for actual method implementation
        return this;
    }

    public SecurityConfiguration addLogoutHandler(ServerLogoutHandler handler) {
        // Placeholder for actual method implementation
        return this;
    }

    public SecurityConfiguration logoutSuccessHandler(org.springframework.security.web.server.WebFilterExchangeHandler handler) {
        // Placeholder for actual method implementation
        return this;
    }

    public SecurityConfiguration requireLogout(ServerWebExchangeMatcher matcher) {
        // Placeholder for actual method implementation
        return this;
    }
}