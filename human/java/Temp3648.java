import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class RefreshApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RefreshApiApplication.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return route(GET("/api/refresh"), request ->
                request.principal().defaultIfEmpty(new FreshStatus(false))
                        .flatMap(it -> {
                            System.out.println(it);
                            return ServerResponse.ok().body(Mono.just(it), FreshStatus.class);
                        }));
    }

    static class FreshStatus {
        private boolean status;

        public FreshStatus(boolean status) {
            this.status = status;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "FreshStatus{" +
                    "status=" + status +
                    '}';
        }
    }
}