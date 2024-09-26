import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomKeycloakRestTemplate extends KeycloakRestTemplate {
    // Custom implementation or additional methods
}

@Configuration
class AppConfig {

    @Autowired
    private CustomKeycloakRestTemplate customKeycloakRestTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return customKeycloakRestTemplate;
    }
}