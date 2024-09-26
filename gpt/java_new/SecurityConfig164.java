import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.HttpStatusServerEntryPoint;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.web.reactive.function.client.WebClient;

public class SecurityConfig164 {

    private void configureCommonSecurity(ServerHttpSecurity http) {
        http.csrf().disable()
                .formLogin()
                .authenticationEntryPoint(new HttpStatusServerEntryPoint(HttpStatus.UNAUTHORIZED))
                .requiresAuthenticationMatcher(
                        ServerWebExchangeMatchers.pathMatchers(HttpMethod.POST, "/api/login"))
                .authenticationFailureHandler((webFilterExchange, exception) -> 
                        WebClient.create()
                                 .post()
                                 .uri("/auth-failure")
                                 .retrieve()
                                 .bodyToMono(Void.class)
                                 .then())
                .authenticationSuccessHandler((webFilterExchange, authentication) -> 
                        WebClient.create()
                                 .post()
                                 .uri("/auth-success")
                                 .retrieve()
                                 .bodyToMono(Void.class)
                                 .then())
                .and()
                .logout()
                .logoutUrl("/api/logout")
                .logoutSuccessHandler((webFilterExchange, authentication) -> 
                        WebClient.create()
                                 .post()
                                 .uri("/logout-success")
                                 .retrieve()
                                 .bodyToMono(Void.class)
                                 .then());
        
        // ... other common configurations
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        configureCommonSecurity(http);
        return http.build();
    }
}