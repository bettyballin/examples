import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.client.ClientDetailsService;

public class Temp2444 {

    private static TokenStore tokenStore;
    private static ClientDetailsService clientRegistrationService;
    private static String clientId;
    private static String email;

    public static void main(String[] args) {
        // Initialize tokenStore, clientRegistrationService, clientId, and email here

        for (ClientDetails client : clientRegistrationService.listClientDetails()) {
            for (final OAuth2AccessToken token : tokenStore.findTokensByClientIdAndUserName(clientId, email)) {
                tokenStore.removeRefreshToken(token.getRefreshToken());
                tokenStore.removeAccessToken(token);
            }
        }
    }
}