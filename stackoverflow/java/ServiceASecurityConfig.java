import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.stereotype.Component;
import java.util.function.Consumer;

@Component
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ServiceASecurityConfig implements HttpSecurityConfig {
    @Override
    public Consumer<ServerHttpSecurity> configuration() {
        return (http) -> {
            http.authorizeExchange(exchanges ->
                    exchanges.pathMatchers(HttpMethod.GET, "/api/serviceA/**").hasAuthority("PROP_A")
            );
        };
    }
}

@Component
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ServiceBSecurityConfig implements HttpSecurityConfig {
    @Override
    public Consumer<ServerHttpSecurity> configuration() {
        return (http) -> {
            http.authorizeExchange(exchanges ->
                    exchanges.pathMatchers(HttpMethod.GET, "/api/serviceB/**").hasAuthority("PROP_B")
            );
        };
    }
}

interface HttpSecurityConfig {
    Consumer<ServerHttpSecurity> configuration();
}