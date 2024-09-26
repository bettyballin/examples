import io.rsocket.core.RSocketClient;
import io.rsocket.transport.ClientTransport;
import io.rsocket.transport.netty.client.WebsocketClientTransport;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import reactor.core.publisher.Hooks;

import java.net.URI;
import java.time.Duration;
import io.rsocket.Payload;
import io.rsocket.util.DefaultPayload;

public class Temp1521 {
    public static void main(String[] args) {
        Hooks.onErrorDropped(e -> {});

        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        ByteBufAllocator allocator = PooledByteBufAllocator.DEFAULT;
        ClientTransport transport = WebsocketClientTransport.create(URI.create("ws://localhost:8080"), eventLoopGroup);

        RSocketClient client = RSocketClient.builder()
                .setupPayload(DefaultPayload.create("data", "metadata"))
                .keepAliveTickPeriod(Duration.ofSeconds(60))
                .keepAliveAckTimeout(Duration.ofSeconds(180))
                .dataMimeType("application/json")
                .metadataMimeType("message/x.rsocket.authentication.v0+json")
                .transport(transport)
                .build();
        
        client.connect().block();
    }
}