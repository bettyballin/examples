import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

public class CustomOAuth2AuthorizationRequestResolver extends DefaultOAuth2AuthorizationRequestResolver {

    public CustomOAuth2AuthorizationRequestResolver(ClientRegistrationRepository clientRegistrationRepository) {
        super(clientRegistrationRepository, "/oauth2/authorization");
    }

    @Override
    public OAuth2AuthorizationRequest resolve(HttpServletRequest request) {
        return super.resolve(request);
    }

    @Override
    public OAuth2AuthorizationRequest.Builder resolve(HttpServletRequest request, String clientRegistrationId) {
        OAuth2AuthorizationRequest.Builder builder = super.resolve(request, clientRegistrationId);
        return expandRedirectUri(builder.build());
    }

    protected OAuth2AuthorizationRequest.Builder expandRedirectUri(OAuth2AuthorizationRequest authorizationRequest) {
        OAuth2AuthorizationRequest.Builder builder = OAuth2AuthorizationRequest.from(authorizationRequest);
        // Custom logic to modify the redirect URI
        String customRedirectUri = authorizationRequest.getRedirectUri() + "?customParam=value";
        builder.redirectUri(customRedirectUri);
        return builder;
    }
}