import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.web.cors.CorsFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class Temp2448 {

    private RequestMatcher authorizationHeaderRequestMatcher;
    private CorsFilter corsFilter;
    private OAuth2ClientContextFilter oAuth2ClientContextFilter;

    public Temp2448(
        @Qualifier("authorizationHeaderRequestMatcher") RequestMatcher authorizationHeaderRequestMatcher, 
        CorsFilter corsFilter, 
        OAuth2ClientContextFilter oAuth2ClientContextFilter
    ) {
        this.authorizationHeaderRequestMatcher = authorizationHeaderRequestMatcher;
        this.corsFilter = corsFilter;
        this.oAuth2ClientContextFilter = oAuth2ClientContextFilter;
    }

    public static void main(String[] args) {
        // Example usage
        // Temp2448 config = new Temp2448(authorizationHeaderRequestMatcher, corsFilter, oAuth2ClientContextFilter);
    }
}