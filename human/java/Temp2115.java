import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.client.ClientDetailsUserDetailsService;
import org.springframework.security.oauth2.provider.ClientDetailsService;

@Configuration
public class AppConfig {

    @Bean
    public ClientDetailsService clientDetails() {
        // Define and return your ClientDetailsService implementation here
        return new InMemoryClientDetailsService(); // Example implementation
    }

    @Bean
    public ClientDetailsUserDetailsService clientDetailsUserService(ClientDetailsService clientDetails) {
        return new ClientDetailsUserDetailsService(clientDetails);
    }
}