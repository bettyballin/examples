import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.http.client.ClientHttpRequestInterceptor;

public class Temp2396 {
    private final OAuth2AuthorizedClientRepository authorizedClientRepository;
    private final ClientRegistrationRepository registrationRepository;

    public Temp2396(OAuth2AuthorizedClientRepository authorizedClientRepository, ClientRegistrationRepository registrationRepository) {
        this.authorizedClientRepository = authorizedClientRepository;
        this.registrationRepository = registrationRepository;
    }

    public static void main(String[] args) {
        // Empty main method for execution
    }

    private ClientHttpRequestInterceptor oauthInterceptor(String id, UserDetails impersonatedUser) {
        return (request, body, execution) -> {
            OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest
                    .withClientRegistrationId(id)
                    .principal(impersonatedUser)
                    .build();
            OAuth2AuthorizedClient client = authorizedClientRepository.loadAuthorizedClient(
                    id, impersonatedUser, null);
            if (client == null) {
                client = authorizedClientRepository.saveAuthorizedClient(
                        new OAuth2AuthorizedClient(
                                registrationRepository.findByRegistrationId(id),
                                impersonatedUser.getUsername(),
                                null),
                        impersonatedUser, null);
            }
            // Add the OAuth2 token to the request headers, assuming bearer token type
            request.getHeaders().add("Authorization", "Bearer " + client.getAccessToken().getTokenValue());
            return execution.execute(request, body);
        };
    }

    // Assuming UserDetails is a custom class for user details
    public static class UserDetails {
        private final String username;

        public UserDetails(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }
}