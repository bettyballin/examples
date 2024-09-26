import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<>();
        // Add user details to the access token.
        additionalInfo.put("user_name", authentication.getName());
        additionalInfo.put("phone_number", "1234567890");  // Replace this with actual phone number from your User object.

        if (accessToken instanceof DefaultOAuth2AccessToken) {
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        } else {
            accessToken = new DefaultOAuth2AccessToken(accessToken);
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        }
        return accessToken;
    }
}