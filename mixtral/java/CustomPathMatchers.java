import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebExchangeMatcher;
import org.springframework.web.util.pattern.PathContainer;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;
import reactor.core.publisher.Mono;

public final class CustomPathMatchers {

    public static ServerWebExchangeMatcher pathIgnoreEmptyAuthorizationHeader(String pattern) {
        return new PathPatternParserServerWebExchangeMatcher("/" + pattern, HttpMethod.ANY);
    }

}

final class PathPatternParserServerWebExchangeMatcher implements ServerWebExchangeMatcher {

    private final String pattern;
    private final HttpMethod method;

    public PathPatternParserServerWebExchangeMatcher(String path, HttpMethod method) {
        this.pattern = path;
        this.method = method;
    }

    @Override
    public Mono<MatchResult> matches(ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();

        if (request == null || !hasEmptyAuthorizationHeader(exchange)) {
            return MatchResult.notMatch();
        }

        PathPatternParser parser = new PathPatternParser();
        PathPattern patternObj = parser.parse(pattern);
        String pathWithinApplication = request.getPath().pathWithinApplication().value();

        if (pathWithinApplication == null) {
            return MatchResult.notMatch();
        }

        PathContainer container = PathContainer.parsePath(pathWithinApplication);

        boolean match;

        try {
            PathPattern.PathMatchInfo info = patternObj.matchAndExtract(container);

            if (info == null) {
                return MatchResult.notMatch();
            }

            match = true;

        } catch (Exception e) {
            match = false;
        }

        if (match && container != null && !container.value().equals(patternObj.toString())) {
            return MatchResult.notMatch();
        }

        return MatchResult.match();
    }

    private boolean hasEmptyAuthorizationHeader(ServerWebExchange exchange) {
        String authorizationHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
        return authorizationHeader == null || authorizationHeader.isEmpty();
    }
}