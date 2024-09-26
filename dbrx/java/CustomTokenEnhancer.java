// CustomTokenEnhancer.java

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.DefaultOAuth2RefreshToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<>();
        String refreshTokenValue = UUID.randomUUID().toString();
        DefaultOAuth2RefreshToken defaultOAuth2RefreshToken = new DefaultOAuth2RefreshToken(refreshTokenValue);
        
        if (accessToken instanceof DefaultOAuth2AccessToken) {
            ((DefaultOAuth2AccessToken) accessToken).setRefreshToken(defaultOAuth2RefreshToken);
        }

        // Add any custom information to the additionalInfo map
        additionalInfo.put("principal", authentication.getPrincipal());
        additionalInfo.put("authorities", authentication.getAuthorities());
        
        if (accessToken instanceof DefaultOAuth2AccessToken) {
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        }

        return accessToken;
    }
}