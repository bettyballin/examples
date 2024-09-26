import java.util.function.Consumer;
import org.springframework.security.config.web.server.ServerHttpSecurity;

public interface HttpSecurityConfig1 {
    Consumer<ServerHttpSecurity> configuration();
}