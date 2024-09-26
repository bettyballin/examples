import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;

@EnableWebFluxSecurity
public class SecurityConfig132 {

  @Bean
  public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
    ServerSecurityContextRepository repo = createContextRepository();

    return http
               .authorizeExchange(exchanges -> exchanges.anyExchange().authenticated())
               .securityContextRepository(repo)
               .build();
  }

  private ServerSecurityContextRepository createContextRepository() {
    // implementation of the context repository
    return null; // replace with actual implementation
  }
}