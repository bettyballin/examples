import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

public class RefreshEndpoint {

    public RouterFunction<ServerResponse> refreshRoute() {
        return route(GET("/api/refresh"), request ->
                request.principal()
                        .map(principal -> new FreshStatus(true)) // Assuming FreshStatus is a valid class
                        .defaultIfEmpty(new FreshStatus(false))
                        .flatMap(freshStatus -> ServerResponse.ok().body(Mono.just(freshStatus), FreshStatus.class))
        );
    }

    class FreshStatus {
        private final boolean status;

        public FreshStatus(boolean status) {
            this.status = status;
        }

        // Getters and setters if necessary
    }
}