import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;

public class ApiTokenAccessFilter extends OAuth2AuthenticationProcessingFilter {

    public ApiTokenAccessFilter(ResourceServerTokenServices resourceServerTokenServices) {
        super();
        setStateless(false);
        setAuthenticationManager(oauthAuthenticationManager(resourceServerTokenServices));
    }

    private AuthenticationManager oauthAuthenticationManager(ResourceServerTokenServices tokenServices) {
        OAuth2AuthenticationManager oauthAuthenticationManager = new OAuth2AuthenticationManager();
        oauthAuthenticationManager.setResourceId("oauth2-resource");
        oauthAuthenticationManager.setTokenServices(tokenServices);
        oauthAuthenticationManager.setClientDetailsService(null);
        return oauthAuthenticationManager;
    }

    public static void main(String[] args) {
        // Example usage
        ResourceServerTokenServices tokenServices = null; // Replace with actual implementation
        ApiTokenAccessFilter filter = new ApiTokenAccessFilter(tokenServices);
        // Add filter to your security configuration
    }
}