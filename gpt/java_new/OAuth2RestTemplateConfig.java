import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

@Configuration
public class OAuth2RestTemplateConfig {

    @Bean
    public OAuth2RestTemplate oauth2RestTemplate() {
        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setClientId("iLHuXeULFBdW4B1dmRY0MhFILRQnlfeK");
        resourceDetails.setClientSecret("RG3JanXEq2R1GhRvIQ2d2AKRx0SORvb3");
        resourceDetails.setAccessTokenUri("https://api.externalsite.com/v1/oauth/token");
        
        return new OAuth2RestTemplate(resourceDetails);
    }
}