import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.resource.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;

import java.util.Arrays;

public class Temp993 {
    public static void main(String[] args) {
        ResourceOwnerPasswordAccessTokenProvider provider = new ResourceOwnerPasswordAccessTokenProvider();
        ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
        resource.setClientAuthenticationScheme(AuthenticationScheme.form);
        resource.setAccessTokenUri("accessTokenURI");
        resource.setClientId("clientId");
        resource.setGrantType("password");
        resource.setClientSecret("clientSecret");
        resource.setUsername("userName");
        resource.setPassword("password");

        OAuth2AccessToken accessToken = provider.obtainAccessToken(resource, new DefaultAccessTokenRequest());
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resource, new DefaultOAuth2ClientContext(accessToken));

        // You can now use restTemplate to make authorized requests
    }
}