import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.web.server.authentication.logout.ServerWebExchangeLogoutHandler;
import org.springframework.security.web.server.authentication.logout.WebFilterChainServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.WebFilterChainServerLogoutSuccessHandler;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.ui.LoginPageGeneratingWebFilter;
import org.springframework.web.server.WebFilter;

public class Temp2801 {
    public static void main(String[] args) {
        System.out.println("Security configuration example.");
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
        LoginPageGeneratingWebFilter loginpage = new LoginPageGeneratingWebFilter();
        loginpage.setFormLoginEnabled(true);
        return httpSecurity
                .addFilterAt(loginpage, SecurityWebFiltersOrder.LOGIN_PAGE_GENERATING)
                .authorizeExchange()
                    .pathMatchers("/home").authenticated()
                    .and().formLogin()
                        .loginPage("/login")
                    .and()
                    .logout()
                        .logoutUrl("/logout")
                        .requiresLogout(ServerWebExchangeMatchers.pathMatchers(HttpMethod.GET, "/logout"))
                    .and()
                .build();
    }
}