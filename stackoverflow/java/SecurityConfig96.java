import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.web.server.ServerWebExchangeMatchers;
import org.springframework.security.web.server.authentication.logout.LogoutWebFilter;
import org.springframework.security.web.server.ui.LoginPageGeneratingWebFilter;
import org.springframework.security.web.server.SecurityWebFilterChain;

public class SecurityConfig96 {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
        LoginPageGeneratingWebFilter loginPage = new LoginPageGeneratingWebFilter();
        loginPage.setFormLoginEnabled(true);
        LogoutWebFilter logoutWebFilter = new LogoutWebFilter();
        logoutWebFilter.setLogoutSuccessHandler((exchange, authentication) -> exchange.getExchange().getResponse().setComplete());

        return httpSecurity
                .addFilterAt(loginPage, SecurityWebFiltersOrder.LOGIN_PAGE_GENERATING)
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/home").authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .requiresLogout(ServerWebExchangeMatchers.pathMatchers(HttpMethod.GET, "/logout"))
                )
                .build();
    }
}