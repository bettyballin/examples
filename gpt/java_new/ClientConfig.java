import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@Configuration
@EnableOAuth2Client
public class ClientConfig {
    @Autowired
    private AuthorizationServerConfig authorizationServerConfig;

    @Bean
    @Scope("prototype")
    public OAuth2ClientContext oAuth2ClientContext() {
        return new DefaultOAuth2ClientContext(new DefaultAccessTokenRequest());
    }

    @Bean
    public OAuth2RestOperations restTemplate(OAuth2ClientContext clientContext) {
        ResourceOwnerPasswordResourceDetails resourceDetails = authorizationServerConfig.getOwnerPasswordResource();
        return new OAuth2RestTemplate(resourceDetails, clientContext);
    }
}