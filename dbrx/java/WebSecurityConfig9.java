import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.authentication.logout.RedirectServerLogoutSuccessHandler;
import org.springframework.security.web.server.context.SecurityContextRepository;
import org.springframework.security.web.server.context.WebSessionServerSecurityContextRepository;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
public class WebSecurityConfig {

    @Autowired
    private ReactiveUserDetailsService userDetailsService;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http
                .authorizeExchange()
                    .pathMatchers("/login", "/logout").permitAll()
                    .anyExchange().authenticated()
                .and()
                .formLogin()
                    .authenticationSuccessHandler(new RedirectServerAuthenticationSuccessHandler("/"))
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessHandler(new RedirectServerLogoutSuccessHandler("/login"))
                .and()
                .securityContextRepository(sessionSecurityContextRepository())
                .build();
    }

    @Bean
    public SecurityContextRepository sessionSecurityContextRepository() {
        WebSessionServerSecurityContextRepository securityContextRepository = new WebSessionServerSecurityContextRepository();
        securityContextRepository.setSpringSecurityContextAttrName("SPRING_SECURITY_CONTEXT");
        return securityContextRepository;
    }
}