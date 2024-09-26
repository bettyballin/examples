import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OAuth2WebClientInterceptor implements ClientHttpRequestInterceptor {

    private final AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager;

    @Autowired
    public OAuth2WebClientInterceptor(
            AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager) {
        this.authorizedClientManager = authorizedClientManager;
    }

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request, byte[] body,
            ClientHttpRequestExecution execution) throws IOException {

        var clientRegistrationId = "your-client";

        OAuth2AuthorizeRequest authorizationRequest =
                OAuth2AuthorizeRequest.withClientRegistrationId(clientRegistrationId)
                        .principal("your-principal")
                        .build();

        OAuth2AuthorizedClient authorizedClient =
                this.authorizedClientManager.authorize(authorizationRequest);

        if (authorizedClient != null) {
            request.getHeaders().setBearerAuth(authorizedClient.getAccessToken().getTokenValue());
        }

        return execution.execute(request, body);
    }
}