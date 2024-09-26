import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.web.server.ServerSecurityContextRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.WebSessionServerSecurityContextRepository;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {

  @Bean
  SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
    ServerSecurityContextRepository repo = createContextRepository();

    return http
               .authorizeExchange(e -> e.anyExchange().authenticated())
               .securityContextRepository(repo)
               .build();
   }

   private ServerSecurityContextRepository createContextRepository() {
       return new WebSessionServerSecurityContextRepository();
   }
}