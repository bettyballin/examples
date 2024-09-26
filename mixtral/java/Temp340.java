import org.springframework.security.oauth2.client.OAuthRestTemplate;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

public class Temp340 {
    public static void main(String[] args) {
        // Create an instance of access token
        String accessTokenValue = "access_token_value_here";
        OAuth2AccessToken accessToken = new DefaultOAuth2AccessToken(accessTokenValue);

        // Create an instance of OAuthRestTemplate
        OAuthRestTemplate oauthRestTemplate = new OAuthRestTemplate();

        // Set it on OAuthRestTemplate
        oauthRestTemplate.getOAuth2ClientContext().setAccessToken(accessToken);

        // Now you can make calls using the provided tokens
    }
}