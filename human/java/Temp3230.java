import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import reactor.core.publisher.Mono;

@Configuration
public class Temp3230 {

    public static void main(String[] args) {
        // Spring Boot applications usually start with SpringApplication.run
        // SpringApplication.run(Temp3230.class, args);
        // However, this code is just a configuration class and main method is not typically used.
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .x509(ServerHttpSecurity.X509Spec::disable)
                .authorizeExchange(exchanges -> exchanges.anyExchange().authenticated())
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails bob = User.withUsername("Bob")
                .authorities("ROLE_USER")
                .password("{noop}") // {noop} is used to specify no encoding for the password
                .build();

        return new InMemoryUserDetailsManager(bob);
    }
}


Note: For this code to be executable, it needs to be part of a Spring Boot application and should be run in an environment where Spring Boot dependencies are properly configured. The `main` method typically used to start a Spring Boot application is commented out as this is just a configuration class.