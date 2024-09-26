import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@EnableOAuth2Client
@Configuration
public class OAuthClientConfig {

    @Autowired
    private AuthorizationServerConfig authorizationServerConfig;

    @Bean
    public OAuth2RestTemplate restTemplate() {
        ResourceOwnerPasswordResourceDetails resourceDetails = authorizationServerConfig.getOwnerPasswordResource();
        return new OAuth2RestTemplate(resourceDetails);
    }
}