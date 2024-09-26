import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.core.Authentication;

import java.util.Map;

public class CustomOAuth2Authentication extends OAuth2Authentication {
    private Map<String, Object> additionalInformation;

    public CustomOAuth2Authentication(OAuth2Request oAuth2Request, Authentication userAuthentication) {
        super(oAuth2Request, userAuthentication);
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(Map<String, Object> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}