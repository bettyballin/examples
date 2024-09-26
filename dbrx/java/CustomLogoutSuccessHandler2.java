Here is the corrected code:


import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public Mono<Void> onLogoutSuccess(WebFilterExchange exchange, Authentication authentication) {
        // Perform any necessary cleanup here

        return ServerResponse.status(HttpStatus.OK)
                .body(BodyInserters.fromValue("Logged out successfully"))
                .build(exchange.getExchange())
                .flatMap(response -> response.writeTo(exchange.getExchange().getResponse()));
    }
}

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http.logout()
                .requiresLogout(ServerWebExchangeMatchers.pathMatchers("/logout"))
                .logoutSuccessHandler(new CustomLogoutSuccessHandler())
                .and().build();
    }
}