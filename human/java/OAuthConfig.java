import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableOAuth2Client
public class OAuthConfig {

    @Value("${OAuth2ClientId}")
    private String oAuth2ClientId;

    @Value("${OAuth2ClientSecret}")
    private String oAuth2ClientSecret;

    @Value("${Oauth2AccesTokenUri}")
    private String accessTokenUri;

    @Bean
    public RestTemplate oAuthRestTemplate() {
        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setId("1");
        resourceDetails.setClientId(oAuth2ClientId);
        resourceDetails.setClientSecret(oAuth2ClientSecret);
        resourceDetails.setAccessTokenUri(accessTokenUri);

        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails, new DefaultOAuth2ClientContext());

        return restTemplate;
    }
}