import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

public class Temp2717 {

    public static void main(String[] args) {
        System.out.println("Temp2717 is running.");
    }

    public void configure(AuthorizationServerEndpointsConfigurer endpoints, AuthenticationManager authenticationManager, TokenEnhancer tokenEnhancer) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                .tokenEnhancer(tokenEnhancer);
    }
}

class CustomTokenEnhancer implements TokenEnhancer {
    @Override
    public org.springframework.security.oauth2.common.OAuth2AccessToken enhance(
            org.springframework.security.oauth2.common.OAuth2AccessToken accessToken,
            org.springframework.security.oauth2.provider.OAuth2Authentication authentication) {
        // Custom token enhancement logic
        return accessToken;
    }
}