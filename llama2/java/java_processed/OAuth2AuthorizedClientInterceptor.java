import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.Optional;

public class OAuth2AuthorizedClientInterceptor implements WebFilter {

    @Override
    public Mono<Void> filter(ServerRequest request, WebFilterChain chain) {
        return Mono.deferContextual(contextView -> {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            OAuth2AuthorizedClient authorizedClient = (OAuth2AuthorizedClient) securityContext.getAuthentication().getPrincipal();
            ServerRequest mutatedRequest = request.mutate().attribute("authorizedClient", authorizedClient).build();
            return chain.filter(mutatedRequest);
        });
    }

    public static RouterFunction<ServerResponse> route() {
        return RouterFunctions.route(RequestPredicates.GET("/example"), request -> {
            Optional<OAuth2AuthorizedClient> authorizedClientOptional = request.attribute("authorizedClient");
            OAuth2AuthorizedClient authorizedClient = authorizedClientOptional.orElse(null);
            // Do something with the authorized client
            return ServerResponse.ok().build();
        });
    }

    public static void main(String[] args) {
        // Example usage:
        RouterFunction<ServerResponse> routerFunction = route();
        // Use routerFunction in your application...
    }
}