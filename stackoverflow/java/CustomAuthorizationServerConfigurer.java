import org.springframework.http.HttpMethod;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.authentication.AuthenticationManager;

public class CustomAuthorizationServerConfigurer {

    private AuthenticationManager authenticationManager;
    private CustomTokenEnhancer customTokenEnhancer;

    public CustomAuthorizationServerConfigurer(AuthenticationManager authenticationManager, CustomTokenEnhancer customTokenEnhancer) {
        this.authenticationManager = authenticationManager;
        this.customTokenEnhancer = customTokenEnhancer;
    }

    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        enhancerChain.setTokenEnhancers(java.util.Arrays.asList(customTokenEnhancer));
        
        endpoints.authenticationManager(authenticationManager)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                .tokenEnhancer(enhancerChain);
    }

    // Assume CustomTokenEnhancer is defined elsewhere
    public static class CustomTokenEnhancer {
        // Custom token enhancer logic goes here
    }
}