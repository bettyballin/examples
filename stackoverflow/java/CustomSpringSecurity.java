import org.springframework.http.HttpStatus;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.security.web.server.authentication.HttpStatusServerEntryPoint;
import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.web.server.WebFilter;
import java.util.List;
import java.util.function.Consumer;

public class CustomSpringSecurity {

    private static void onAuthenticationFailure() {
        // custom authentication failure logic
    }

    private static void onAuthenticationSuccess() {
        // custom authentication success logic
    }

    private static void convert() {
        // custom server authentication converter logic
    }

    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http, List<Consumer<ServerHttpSecurity>> httpConfigurations) {
        http.securityMatcher(ServerWebExchangeMatchers.pathMatchers("/api/**"));

        httpConfigurations.forEach(config -> config.accept(http));

        http.authorizeExchange()
                .pathMatchers("/api/login", "/api/logout", "/api/forgotPassword", "/api/confirmForgotPassword").permitAll()
                .and()
                .csrf().disable()
                .formLogin()
                .authenticationEntryPoint(new HttpStatusServerEntryPoint(HttpStatus.UNAUTHORIZED))
                .authenticationFailureHandler((ServerAuthenticationFailureHandler) CustomSpringSecurity::onAuthenticationFailure)
                .authenticationSuccessHandler((ServerAuthenticationSuccessHandler) CustomSpringSecurity::onAuthenticationSuccess)
                .and()
                .logout()
                .logoutUrl("/api/logout");

        return http.build();
    }
}