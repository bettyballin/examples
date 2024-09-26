import org.springframework.http.HttpMethod;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.SessionRepository;
import org.springframework.security.web.server.savedrequest.RequestCache;
import org.springframework.security.web.server.savedrequest.SavedRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.adapter.DefaultServerWebExchange;
import org.springframework.web.server.adapter.DefaultServerWebExchangeBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;

public class Temp1157 {
    public static void main(String[] args) {
        SessionRepository sessionRepository = new MapSessionRepository();

        ServerWebExchange exchange = new DefaultServerWebExchangeBuilder(new URI("http://localhost"))
                .method(HttpMethod.GET)
                .build();

        CustomRequestCache customRequestCache = new CustomRequestCache(sessionRepository);
        customRequestCache.saveRequest(exchange);
    }
}

class CustomRequestCache implements RequestCache {

    private final SessionRepository sessionRepository;

    public CustomRequestCache(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public Mono<SavedRequest> getRedirectUri(ServerWebExchange exchange) {
        return Mono.empty();
    }

    @Override
    public void removeMatchingRequest(ServerWebExchange exchange) {

    }

    @Override
    public void saveRequest(ServerWebExchange exchange) {
        SavedRequest savedRequest = new SavedRequest(exchange);
        sessionRepository.createSession().block().setAttribute("savedRequest", savedRequest);
    }
}