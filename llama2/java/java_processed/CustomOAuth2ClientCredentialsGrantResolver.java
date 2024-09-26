import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2ClientCredentialsGrantResolver extends DefaultTokenServices {

    @Override
    public OAuth2AccessToken createAccessToken(OAuth2Authentication authentication) {
        BaseClientDetails client = (BaseClientDetails) authentication.getUserAuthentication().getPrincipal();
        // Custom grant logic
        return super.createAccessToken(authentication);
    }
}