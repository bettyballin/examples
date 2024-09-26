import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.client.ClientDetailsUserDetailsService;
import org.springframework.security.oauth2.provider.ClientDetailsService;

@Configuration
public class AppConfig {

    private final ClientDetailsService myClientDetails;

    public AppConfig(ClientDetailsService myClientDetails) {
        this.myClientDetails = myClientDetails;
    }

    @Bean
    public ClientDetailsUserDetailsService clientDetailsUserService() {
        return new ClientDetailsUserDetailsService(myClientDetails);
    }
}