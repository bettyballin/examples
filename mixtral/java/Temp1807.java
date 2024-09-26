import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity.SecurityWebFilterChain;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import reactor.core.publisher.Mono;

public class Temp1807 {
    
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
            .exceptionHandling()
            .authenticationEntryPoint(new CustomAuthenticationEntryPoint());
        return http.build();
    }

    private class CustomAuthenticationEntryPoint implements ServerHttpSecurity.AuthenticationEntryPoint {
        @Override
        public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException e) {
            // Custom handling here
            return Mono.empty();
        }
    }

    // Your UserRepository and UserDetailsImpl classes should be defined somewhere
    private UserRepository userRepository;

    public class MyCustomExceptionThrownFromFindByUsername extends RuntimeException {
        public MyCustomExceptionThrownFromFindByUsername(String message) {
            super(message);
        }
    }

    public class UserDetailsImpl implements UserDetails {
        // Implement necessary methods here
    }

    public class UserRepository {
        public Mono<User> findByUsername(String username) {
            // Fetch user from data source
            return Mono.empty(); // Placeholder
        }
    }

    public class User {
        public boolean isEnabled() {
            return true; // Placeholder
        }
    }

    @Bean
    public ReactiveUserDetailsService userDetailsService() {
        return new ReactiveUserDetailsService() {
            @Override
            public Mono<UserDetails> findByUsername(String username) {
                return userRepository.findByUsername(username)
                    .flatMap(user ->
                        (user.isEnabled() ?
                            Mono.justOrEmpty(new UserDetailsImpl()) :
                            Mono.error(() -> new MyCustomExceptionThrownFromFindByUsername("Account is disabled")))
                    )
                    .switchIfEmpty(Mono.error(new UsernameNotFoundException("User not found")));
            }
        };
    }

    public static void main(String[] args) {
        // Application entry point
    }
}