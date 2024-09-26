import org.springframework.security.oauth2.client.endpoint.NimbusAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AccessTokenResponse;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse.Builder;

public class CustomLinkedInAccessTokenResponseClient implements OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> {

    private final NimbusAuthorizationCodeTokenResponseClient delegate = new NimbusAuthorizationCodeTokenResponseClient();

    @Override
    public OAuth2AccessTokenResponse getTokenResponse(OAuth2AuthorizationCodeGrantRequest authorizationCodeGrantRequest) {
        OAuth2AccessTokenResponse response = this.delegate.getTokenResponse(authorizationCodeGrantRequest);
        OAuth2AccessToken accessToken = response.getAccessToken();

        Builder builder = OAuth2AccessTokenResponse.withToken(accessToken.getTokenValue())
                .tokenType(accessToken.getTokenType())
                .scopes(accessToken.getScopes())
                .refreshToken(response.getRefreshToken() != null ? response.getRefreshToken().getTokenValue() : null)
                .additionalParameters(response.getAdditionalParameters());

        if (accessToken.getExpiresAt() != null) {
            builder.expiresIn(accessToken.getExpiresAt().toEpochMilli() - System.currentTimeMillis());
        }

        return builder.build();
    }

    public static void main(String[] args) {
        System.out.println("CustomLinkedInAccessTokenResponseClient is ready to be used.");
    }
}