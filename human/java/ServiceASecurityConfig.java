import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.stereotype.Component;
import java.util.function.Consumer;

public interface HttpSecurityConfig {
    Consumer<ServerHttpSecurity> configuration();
}

@Component
public class ServiceASecurityConfig implements HttpSecurityConfig {
    @Override
    public Consumer<ServerHttpSecurity> configuration() {
        return (http) -> {
            http.authorizeExchange()
                    .pathMatchers(HttpMethod.GET, "/api/serviceA/**")
                    .hasAuthority("PROP_A");
        };
    }
}

@Component
public class ServiceBSecurityConfig implements HttpSecurityConfig {
    @Override
    public Consumer<ServerHttpSecurity> configuration() {
        return (http) -> {
            http.authorizeExchange()
                    .pathMatchers(HttpMethod.GET, "/api/serviceB/**")
                    .hasAuthority("PROP_B");
        };
    }
}

@Configuration
@EnableWebFluxSecurity
@ComponentScan(basePackageClasses = {ServiceASecurityConfig.class, ServiceBSecurityConfig.class})
public class SecurityConfig {

    private final ServiceASecurityConfig serviceASecurityConfig;
    private final ServiceBSecurityConfig serviceBSecurityConfig;

    public SecurityConfig(ServiceASecurityConfig serviceASecurityConfig, ServiceBSecurityConfig serviceBSecurityConfig) {
        this.serviceASecurityConfig = serviceASecurityConfig;
        this.serviceBSecurityConfig = serviceBSecurityConfig;
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        serviceASecurityConfig.configuration().accept(http);
        serviceBSecurityConfig.configuration().accept(http);
        return http.build();
    }
}