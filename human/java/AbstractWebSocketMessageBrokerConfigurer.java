import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @deprecated as of 5.0 in favor of simply using {@link WebSocketMessageBrokerConfigurer}
 * which has default methods, made possible by a Java 8 baseline.
 */
@Deprecated
public abstract class AbstractWebSocketMessageBrokerConfigurer implements WebSocketMessageBrokerConfigurer {

}