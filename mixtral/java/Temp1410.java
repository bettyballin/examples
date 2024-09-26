import org.springframework.beans.factory.annotation.Bean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.token.AccessTokenProvider;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.AuthorizationCodeAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.client.token.request.TokenRequestEnhancer;
import java.util.Arrays;

public class Temp1410 {

    public static void main(String[] args) {
        // You can test the beans here if necessary
    }

    @Bean
    public AccessTokenProvider sparklrAccessTokenProvider(
            @Qualifier("sparklrRestTemplate") OAuth2RestOperations restTemplate,
            SparklrOauthClientDetailsService clientDetails) {
        AuthorizationCodeAccessTokenProvider accessTokenProvider = new AuthorizationCodeAccessTokenProvider();

        TokenRequestEnhancer tokenRequestEnhancer = (accessTokenRequest ->
                ((AuthorizationCodeResourceDetails) clientDetails.getClient()).setScope(Arrays.asList("read")));

        return new AccessTokenProviderChain(
                Arrays.<AccessTokenProvider>asList(
                        accessTokenProvider
                ));
    }

    @Bean
    public AccessTokenProvider facebookAccessTokenProvider() {
        AuthorizationCodeAccessTokenProvider accessTokenProvider = new AuthorizationCodeAccessTokenProvider();

        TokenRequestEnhancer tokenRequestEnhancer = (accessTokenRequest ->
                ((AuthorizationCodeResourceDetails) facebook()).setScope(Arrays.asList("public_profile")));

        return new AccessTokenProviderChain(
                Arrays.<AccessTokenProvider>asList(
                        accessTokenProvider
                ));
    }

    // Mock method to simulate the facebook() method
    public AuthorizationCodeResourceDetails facebook() {
        return new AuthorizationCodeResourceDetails();
    }

    // Mock class to simulate the SparklrOauthClientDetailsService
    public static class SparklrOauthClientDetailsService {
        public AuthorizationCodeResourceDetails getClient() {
            return new AuthorizationCodeResourceDetails();
        }
    }
}