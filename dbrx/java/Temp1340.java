import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.client.token.AccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import java.util.ArrayList;

public class Temp1340 {
    public static void main(String[] args) {
        // Setup resource details
        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setClientId("your-client-id");
        resourceDetails.setClientSecret("your-client-secret");
        resourceDetails.setAccessTokenUri("https://your-auth-server/token");
        resourceDetails.setGrantType("client_credentials");

        // Create OAuth2RestTemplate
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails);

        // Obtain access token
        OAuth2AccessToken accessToken = restTemplate.getAccessToken();

        // Now you can use this access token with your OAuth2RestTemplate.
        System.out.println("Access Token: " + accessToken.getValue());
    }
}