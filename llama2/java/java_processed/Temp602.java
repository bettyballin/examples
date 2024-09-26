import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.RequestPredicates;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

public class Temp602 {
    public static void main(String[] args) {
        RouterFunction<ServerResponse> route = RouterFunctions.route(
                RequestPredicates.GET("/hello"),
                request -> ServerResponse.ok().body(Mono.just("Hello, World!"), String.class)
        );
        // To make the route executable, you need to create a server and run it.
        // Here, we will use the Netty server for this purpose.
        // If you are using Spring Boot, this would typically be done using the 
        // @SpringBootApplication annotation on your application class.
        // For simplicity, we will just use the Netty server here.

        // This requires additional imports:
        import reactor.netty.DisposableServer;
        import reactor.netty.http.server.HttpServer;

        // Create server and run it (blocking):
        DisposableServer server = HttpServer.create().host("localhost").port(8080)
            .handle(route).bindNow();
        System.out.println("Server running on port 8080. Press enter to stop");
        System.in.read();
        server.disposeNow();
    }
}