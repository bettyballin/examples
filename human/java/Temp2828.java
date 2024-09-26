import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.authentication.HttpStatusServerEntryPoint;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.security.web.server.DelegatingServerAuthenticationEntryPoint;
import org.springframework.web.server.WebFilter;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;

import java.util.List;

public class Temp2828 {
    public static void main(String[] args) {
        // Dummy main method
    }

    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http, final List<HttpSecurityConfig> httpConfigurations) {
        http.securityMatcher(ServerWebExchangeMatchers.pathMatchers("/api/**"))
                .authenticationManager(this.authenticationManager);

        // This line replaces the individual configurations in your original question
        httpConfigurations.forEach(config -> config.configuration().accept(http));

        http.authorizeExchange().pathMatchers(HttpMethod.POST, "/api/login", "/api/logout", "/api/forgotPassword", "/api/confirmForgotPassword").permitAll();

        http.csrf()
                .disable()
                .formLogin()
                .authenticationEntryPoint(new HttpStatusServerEntryPoint(HttpStatus.UNAUTHORIZED))
                .requiresAuthenticationMatcher(
                        ServerWebExchangeMatchers.pathMatchers(HttpMethod.POST, "/api/login"))
                .authenticationFailureHandler(CustomSpringSecurity::onAuthenticationFailure)
                .authenticationSuccessHandler(CustomSpringSecurity::onAuthenticationSuccess)
                .and()
                .logout()
                .logoutUrl("/api/logout")
                .logoutSuccessHandler(new CustomLogoutSuccessHandler(HttpStatus.OK));

        final SecurityWebFilterChain build = http.build();

        build
                .getWebFilters()
                .collectList()
                .subscribe(
                        webFilters -> {
                            for (WebFilter filter : webFilters) {
                                if (filter instanceof AuthenticationWebFilter) {
                                    AuthenticationWebFilter awf = (AuthenticationWebFilter) filter;
                                    awf.setServerAuthenticationConverter(CustomSpringSecurity::convert);
                                }
                            }
                        });

        return build;
    }

    // Dummy methods to make the code compile
    private Object authenticationManager;
    interface HttpSecurityConfig {
        java.util.function.Consumer<ServerHttpSecurity> configuration();
    }
    static class CustomSpringSecurity {
        static void onAuthenticationFailure(Object o1, Object o2) {}
        static void onAuthenticationSuccess(Object o1, Object o2) {}
        static Object convert(Object o) { return null; }
    }
    static class CustomLogoutSuccessHandler implements org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler {
        public CustomLogoutSuccessHandler(HttpStatus httpStatus) {}
        @Override
        public reactor.core.publisher.Mono<Void> onLogoutSuccess(org.springframework.web.server.WebFilterExchange exchange, org.springframework.security.core.Authentication authentication) {
            return reactor.core.publisher.Mono.empty();
        }
    }
}