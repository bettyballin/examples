import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class TokenService {

    @Autowired
    private ServerOAuth2AuthorizedClientRepository authorizedClients;

    public Mono<String> getTokenValue(ServerWebExchange exchange) {
        return ReactiveSecurityContextHolder
            .getContext()
            .map(context -> context.getAuthentication())
            .filter(authentication -> authentication instanceof OAuth2AuthenticatedPrincipal)
            .cast(OAuth2AuthenticatedPrincipal.class)
            .flatMap(principal -> authorizedClients
                .loadAuthorizedClient("new-be-app", principal, exchange))
            .map(authorizedClient -> authorizedClient
                    .getAccessToken()
                    .getTokenValue());
    }
}