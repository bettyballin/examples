import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

@Configuration
public class ExternalServiceConfig {

    @Autowired
    private UserRepository userRepo; // Assuming UserRepository is defined elsewhere in your project

    // Create a bean for each client credentials set

    @Bean
    public OAuth2ProtectedResourceDetails externalServiceCredentials1() {
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();

        // Set the properties based on your database configuration
        details.setClientId("your-client-id");
        details.setClientSecret("your-client-secret");
        details.setAccessTokenUri("your-access-token-uri");

        return details;
    }

    // Add additional beans similarly if needed

    // Example:
    @Bean
    public OAuth2ProtectedResourceDetails externalServiceCredentials2() {
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();

        // Set the properties based on your database configuration
        details.setClientId("your-second-client-id");
        details.setClientSecret("your-second-client-secret");
        details.setAccessTokenUri("your-second-access-token-uri");

        return details;
    }
}