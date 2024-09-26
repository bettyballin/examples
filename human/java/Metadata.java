// Java Metadata Builder
import io.rsocket.metadata.CompositeMetadata;
import io.rsocket.metadata.WellKnownMimeType;
import io.rsocket.metadata.CompositeMetadata.Entry;

import java.nio.charset.StandardCharsets;

public class Metadata {
    private String route;
    private Auth auth;

    public Metadata(String route, Auth auth) {
        this.route = route;
        this.auth = auth;
    }

    public CompositeMetadata toMetadata() {
        CompositeMetadata metadata = new CompositeMetadata();
        if (auth != null) {
            if (auth.type.equals("bearer")) {
                metadata.add(WellKnownMimeType.MESSAGE_RSOCKET_AUTHENTICATION, auth.token.getBytes(StandardCharsets.UTF_8));
            }
            if (auth.type.equals("simple")) {
                metadata.add(WellKnownMimeType.MESSAGE_RSOCKET_AUTHENTICATION, (auth.username + ":" + auth.password).getBytes(StandardCharsets.UTF_8));
            }
        }
        if (route != null) {
            metadata.add(WellKnownMimeType.MESSAGE_RSOCKET_ROUTING, route.getBytes(StandardCharsets.UTF_8));
        }
        return metadata;
    }

    static class Auth {
        String type;
        String token;
        String username;
        String password;

        public Auth(String type, String token, String username, String password) {
            this.type = type;
            this.token = token;
            this.username = username;
            this.password = password;
        }
    }
}

// Java RSocket Client Class
import io.rsocket.core.RSocketClient;
import io.rsocket.core.RSocketConnector;
import io.rsocket.transport.netty.client.WebsocketClientTransport;
import reactor.core.publisher.Mono;

public class SpringClient {
    private RSocketClient client;
    private Metadata.Auth auth;

    public SpringClient(String wsUrl, int keepAlive, int lifetime, String dataMimeType) {
        this.client = RSocketConnector.create()
                .keepAlive(Duration.ofMillis(keepAlive), Duration.ofMillis(lifetime))
                .metadataMimeType(WellKnownMimeType.MESSAGE_RSOCKET_COMPOSITE_METADATA.getString())
                .dataMimeType(dataMimeType)
                .connect(WebsocketClientTransport.create(wsUrl))
                .block();
    }

    public void bearerAuth(String token) {
        this.auth = new Metadata.Auth("bearer", token, null, null);
    }

    public void simpleAuth(String username, String password) {
        this.auth = new Metadata.Auth("simple", null, username, password);
    }

    public void logout() {
        this.auth = null;
    }

    public void requestResponse(String data, String route, 
                                Consumer<String> completeCallback, 
                                Consumer<Throwable> errorCallback) {
        if (this.client != null) {
            CompositeMetadata metadata = new Metadata(route, auth).toMetadata();
            client.requestResponse(DefaultPayload.create(data, metadata))
                    .map(payload -> payload.getDataUtf8())
                    .doOnError(errorCallback)
                    .subscribe(completeCallback);
        }
    }
}

// Example Usage
public class Main {
    public static void main(String[] args) {
        SpringClient client = new SpringClient("ws://localhost:7000/", 5000, 15000, "text/plain");
        client.simpleAuth("LOGIN", "PASSWORD");
        client.requestResponse("MESSAGE", "ROUTE",
                data -> {
                    System.out.println("got response with requestResponse");
                    System.out.println(data);
                },
                error -> {
                    System.out.println("got error with requestResponse");
                    System.err.println(error);
                }
        );
    }
}