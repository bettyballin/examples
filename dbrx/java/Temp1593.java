import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.util.Assert;

import java.io.IOException;

public class Temp1593 {
    private static final String ANONYMOUS_AUTHENTICATION = "anonymous";
    private OAuth2AuthorizedClientManager manager;

    public Temp1593(OAuth2AuthorizedClientManager manager) {
        this.manager = manager;
    }

    public static void main(String[] args) {
        // Example usage
        OAuth2AuthorizedClientManager manager = null; // Initialize with actual manager
        Temp1593 temp = new Temp1593(manager);
        ClientHttpRequestInterceptor interceptor = temp.oauthInterceptor("client_id");
    }

    private ClientHttpRequestInterceptor oauthInterceptor(String id) {
        return new ClientHttpRequestInterceptor() {
            @Override
            public org.springframework.http.client.ClientHttpResponse intercept(org.springframework.http.HttpRequest request, byte[] body, org.springframework.http.client.ClientHttpRequestExecution execution) throws IOException {
                OAuth2AuthorizedClient client = manager.authorize(
                    OAuth2AuthorizeRequest.withClientRegistrationId(id)
                        .principal(ANONYMOUS_AUTHENTICATION)
                        .attribute("on_behalf_of", "user_id_or_jwt")
                        .build()
                );
                Assert.notNull(client, "Can not access File Storage Service");
                request.getHeaders().setBearerAuth(client.getAccessToken().getTokenValue());
                return execution.execute(request, body);
            }
        };
    }
}