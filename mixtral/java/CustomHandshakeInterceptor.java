import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class CustomHandshakeInterceptor implements HandshakeInterceptor {

    @Autowired
    private SecurityContextRepository securityContextRepo;

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        // No action needed after handshake
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        // Get security context from HTTP session
        SecurityContext httpSessionSecurityCtx = this.securityContextRepo.loadContext((HttpServletRequest) request).get();

        if (httpSessionSecurityCtx != null &&
                !CollectionUtils.isEmpty(httpSessionSecurityCtx.getAuthentication().getPrincipal())) {
            // Set security context in WebSocket session
            SecurityContextHolder.setContext(httpSessionSecurityCtx);
            return true;
        }
        
        return false;
    }
}