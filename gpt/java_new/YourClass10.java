import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.UserInfoTokenServices;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class YourClass10 {
    private String userInfoUri;
    private String clientId;

    private OAuth2RestTemplate restTemplate() {
        // Assuming restTemplate() method is defined elsewhere in your class
        return new OAuth2RestTemplate(null); // replace null with the appropriate OAuth2ProtectedResourceDetails
    }

    private OAuth2ClientAuthenticationProcessingFilter ssoFilter() {
        OAuth2ClientAuthenticationProcessingFilter openIDFilter = new OAuth2ClientAuthenticationProcessingFilter("/login");
        openIDFilter.setRestTemplate(restTemplate());
        ResourceServerTokenServices tokenServices = new UserInfoTokenServices(userInfoUri, clientId);
        tokenServices.setRestTemplate(restTemplate());
        openIDFilter.setTokenServices(tokenServices);

        openIDFilter.setAuthenticationSuccessHandler(new SavedRequestAwareAuthenticationSuccessHandler());

        return openIDFilter;
    }
}