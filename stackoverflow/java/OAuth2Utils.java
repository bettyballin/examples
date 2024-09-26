import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.server.ServerRequest;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class OAuth2Utils {

    private final ServerOAuth2AuthorizedClientRepository authorizedClientRepository;

    public Mono<OAuth2AuthorizedClient> extractOAuth2AuthorizedClient(ServerRequest request) {
        return request.principal()
                .filter(principal -> principal instanceof OAuth2AuthenticationToken)
                .cast(OAuth2AuthenticationToken.class)
                .flatMap(auth -> authorizedClientRepository.loadAuthorizedClient(
                    auth.getAuthorizedClientRegistrationId(), auth, request.exchange()));
    }
}