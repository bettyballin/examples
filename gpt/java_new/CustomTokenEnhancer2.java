import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer2 implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        DefaultOAuth2AccessToken defaultAccessToken = (DefaultOAuth2AccessToken) accessToken;
        Map<String, Object> additionalInfo = new HashMap<>();
        // Add your custom information
        additionalInfo.put("custom_info", "value");
        defaultAccessToken.setAdditionalInformation(additionalInfo);
        return defaultAccessToken;
    }
}