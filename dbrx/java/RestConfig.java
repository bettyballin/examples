import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.web.client.RestOperations;

@Configuration
public class RestConfig {

    @Bean
    public RestOperations restTemplate(OAuth2ClientContext oauth2ClientContext, OAuth2ProtectedResourceDetails resource) {
        AccessTokenRequest atr = new DefaultAccessTokenRequest();
        return new OAuth2RestTemplate(resource, oauth2ClientContext, atr);
    }

    @Bean
    public OAuth2ClientContext oauth2ClientContext() {
        return new DefaultOAuth2ClientContext();
    }

    @Bean
    public OAuth2ProtectedResourceDetails resource() {
        // Implement your resource details
        return new OAuth2ProtectedResourceDetails() {
            // Implement all required methods
        };
    }
}