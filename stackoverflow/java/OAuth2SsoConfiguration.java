import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.CorsFilter;

public class OAuth2SsoConfiguration {

    private RequestMatcher authorizationHeaderRequestMatcher;
    private CorsFilter corsFilter;
    private OAuth2ClientContextFilter oAuth2ClientContextFilter;

    public OAuth2SsoConfiguration(
        @Qualifier("authorizationHeaderRequestMatcher") RequestMatcher authorizationHeaderRequestMatcher, 
        CorsFilter corsFilter, 
        OAuth2ClientContextFilter oAuth2ClientContextFilter
    ) {
        this.authorizationHeaderRequestMatcher = authorizationHeaderRequestMatcher;
        this.corsFilter = corsFilter;
        this.oAuth2ClientContextFilter = oAuth2ClientContextFilter;
        // .....
    }

    // Rest of the class...
}