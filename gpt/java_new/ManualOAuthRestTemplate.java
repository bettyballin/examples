import org.springframework.security.oauth.consumer.BaseProtectedResourceDetails;
import org.springframework.security.oauth.consumer.OAuthRestTemplate;
import org.springframework.security.oauth.consumer.token.StaticOAuthTokenServices;

public class ManualOAuthRestTemplate {

    public static OAuthRestTemplate createOAuthRestTemplate(String consumerKey, String consumerSecret, String tokenValue, String tokenSecret) {
        BaseProtectedResourceDetails resourceDetails = new BaseProtectedResourceDetails();
        resourceDetails.setConsumerKey(consumerKey);
        resourceDetails.setSharedSecret(new org.springframework.security.oauth.common.signature.SharedConsumerSecretImpl(consumerSecret));
        resourceDetails.setId("oauthResource");

        StaticOAuthTokenServices tokenServices = new StaticOAuthTokenServices();
        org.springframework.security.oauth.consumer.token.OAuthConsumerToken accessToken = new org.springframework.security.oauth.consumer.token.OAuthConsumerToken();
        accessToken.setValue(tokenValue);
        accessToken.setSecret(tokenSecret);
        tokenServices.setAccessToken(accessToken);

        OAuthRestTemplate restTemplate = new OAuthRestTemplate(resourceDetails);
        restTemplate.setOAuthConsumerTokenServices(tokenServices);

        return restTemplate;
    }
}