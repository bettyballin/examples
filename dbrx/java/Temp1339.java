import org.springframework.security.oauth2.client.resource.OAuth2AccessTokenSupport;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.resource.RefreshTokenOnlyResourceDetails;
import org.springframework.security.oauth2.common.GrantType;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

public class Temp1339 {
    
    static class ApiProperties {
        private String clientId;
        private String clientSecret;

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getClientSecret() {
            return clientSecret;
        }

        public void setClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
        }
    }

    public static void main(String[] args) {
        ApiProperties apiProperties = new ApiProperties();
        apiProperties.setClientId("your-client-id");
        apiProperties.setClientSecret("your-client-secret");
        String refreshToken = "your-refresh-token";
        RestOperations restOperations = null; // Initialize RestOperations appropriately

        RefreshTokenOnlyResourceDetails details = new RefreshTokenOnlyResourceDetails();
        details.setClientId(apiProperties.getClientId());
        details.setClientSecret(apiProperties.getClientSecret());
        details.setGrantType(GrantType.REFRESH_TOKEN);
        details.setRefreshToken(refreshToken);

        OAuth2AccessTokenSupport accessTokenProvider = new OAuth2AccessTokenSupport() {
            @Override
            protected MultiValueMap<String, String> getParametersForTokenRequest(AccessTokenRequest request) {
                return super.getParametersForTokenRequest(request); // Add any additional parameters here if needed.
            }
        };

        accessTokenProvider.setRestTemplate(restOperations);
    }
}