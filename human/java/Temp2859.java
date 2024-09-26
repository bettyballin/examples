import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temp2859 {
    public static void main(String[] args) {
        // Example usage
        AuthorizationServerEndpointsConfigurer endpoints = new AuthorizationServerEndpointsConfigurer();
        Temp2859 temp = new Temp2859();
        TokenGranter granter = temp.tokenGranter(endpoints);
        System.out.println(granter);
    }

    private TokenGranter tokenGranter(final AuthorizationServerEndpointsConfigurer endpoints) {
        List<TokenGranter> granters = new ArrayList<>(Arrays.asList(endpoints.getTokenGranter()));
        granters.add(new CustomGrantTokenGranter(endpoints.getTokenServices(), endpoints.getClientDetailsService(), endpoints.getOAuth2RequestFactory(), "custom_grant"));
        return new CompositeTokenGranter(granters);
    }
}

// Dummy implementations to make the code executable
class CustomGrantTokenGranter implements TokenGranter {
    public CustomGrantTokenGranter(Object tokenServices, Object clientDetailsService, Object oAuth2RequestFactory, String custom_grant) {
        // Implementation here
    }

    @Override
    public org.springframework.security.oauth2.common.OAuth2AccessToken grant(String grantType, org.springframework.security.oauth2.provider.OAuth2AuthenticationToken authentication) {
        return null;
    }
}

class AuthorizationServerEndpointsConfigurer {
    public TokenGranter getTokenGranter() {
        return new TokenGranter() {
            @Override
            public org.springframework.security.oauth2.common.OAuth2AccessToken grant(String grantType, org.springframework.security.oauth2.provider.OAuth2AuthenticationToken authentication) {
                return null;
            }
        };
    }

    public Object getTokenServices() {
        return new Object();
    }

    public Object getClientDetailsService() {
        return new Object();
    }

    public Object getOAuth2RequestFactory() {
        return new Object();
    }
}