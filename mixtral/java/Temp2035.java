import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.client.KeycloakSpringBootProperties;
import org.keycloak.representations.adapters.config.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;

@Configuration
public class Temp2035 {
    public static void main(String[] args) {
        // Main method content if necessary
    }

    @Bean
    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

    @Autowired
    private void configKeycloak(KeycloakSpringBootProperties properties) throws MalformedURLException {
        // Set the realm auth server URL and credentials
        properties.setRealm("your-realm");
        properties.setAuthServerUrl("http://localhost:8081/auth");
        properties.setResource("client-id");
        Credentials credentials = new Credentials();
        credentials.setSecret("secret");
        properties.setCredentials(credentials);
    }
}