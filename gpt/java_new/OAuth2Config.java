import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OAuth2Config {

    private String googleClientId;
    private String googleClientSecret;
    private String googleOAuthUri;
    private String googleTokenUrl;

    // Constructor to initialize the class with necessary values if required
    public OAuth2Config(String googleClientId, String googleClientSecret, String googleOAuthUri, String googleTokenUrl) {
        this.googleClientId = googleClientId;
        this.googleClientSecret = googleClientSecret;
        this.googleOAuthUri = googleOAuthUri;
        this.googleTokenUrl = googleTokenUrl;
    }

    @Bean
    public AuthorizationCodeResourceDetails googleOAuth2Details() {
        AuthorizationCodeResourceDetails googleOAuth2Details = new AuthorizationCodeResourceDetails();
        googleOAuth2Details.setAuthenticationScheme(AuthenticationScheme.form);
        googleOAuth2Details.setClientAuthenticationScheme(AuthenticationScheme.form);
        googleOAuth2Details.setClientId(googleClientId);
        googleOAuth2Details.setClientSecret(googleClientSecret);
        googleOAuth2Details.setUserAuthorizationUri(googleOAuthUri);
        googleOAuth2Details.setAccessTokenUri(googleTokenUrl);
        googleOAuth2Details.setScope(Arrays.asList("openid", "email"));
        googleOAuth2Details.setUseCurrentUri(false);

        Map<String, Object> additionalParameters = new HashMap<>();
        additionalParameters.put("access_type", "offline");
        googleOAuth2Details.setAdditionalParameters(additionalParameters);

        return googleOAuth2Details;
    }
}