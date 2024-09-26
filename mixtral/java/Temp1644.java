import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Temp1644 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1644.class, args);
    }

    @Autowired
    private OAuth2ClientContext oauth2ClientContext;

    @Autowired
    private OAuth2RestTemplate restTemplate;

    public void callExternalService() {
        AccessTokenRequest atr = new DefaultAccessTokenRequest();

        // set the clientId and secret

        ResponseEntity<String> response = this.restTemplate.exchange(
                "https://api.externalSite.com/v1/{resource}",
                HttpMethod.GET,
                null,
                String.class
        );

        System.out.println(response.getBody());
    }
}

@Configuration
class OAuth2ClientConfig {

    @Bean
    public OAuth2RestTemplate restTemplate(OAuth2ClientContext oauth2ClientContext) {
        return new OAuth2RestTemplate(resourceDetails(), oauth2ClientContext);
    }

    @Bean
    public ClientCredentialsResourceDetails resourceDetails() {
        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setClientId("your-client-id");
        resourceDetails.setClientSecret("your-client-secret");
        resourceDetails.setAccessTokenUri("https://auth.server.com/oauth/token");
        return resourceDetails;
    }
}