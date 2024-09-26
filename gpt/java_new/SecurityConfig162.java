import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.logout.RedirectServerLogoutSuccessHandler;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher;

import java.net.URI;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig162 {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        RedirectServerLogoutSuccessHandler logoutSuccessHandler = new RedirectServerLogoutSuccessHandler();
        logoutSuccessHandler.setLogoutSuccessUrl(URI.create("/"));
        
        return http
            .logout(logout -> logout
                .requiresLogout(ServerWebExchangeMatcher.pathMatchers(HttpMethod.GET, "/logout"))
                .logoutSuccessHandler(logoutSuccessHandler))
            .csrf().disable()
            .build();
    }
}