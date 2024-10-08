import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer1 implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
        
        Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("errorLevel", "OK");
        additionalInfo.put("errorMsg", "You are now connected");
        
        customAccessToken.setAdditionalInformation(additionalInfo);
        
        return customAccessToken;
    }
}