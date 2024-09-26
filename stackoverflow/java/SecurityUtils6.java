import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.cometd.bayeux.server.ServerMessage;
import org.cometd.bayeux.server.BayeuxContext;

public class SecurityUtils6 {
    public static void authenticateUser(ServerMessage message) {
        BayeuxContext bayeuxContext = message.getBayeuxContext();
        if (bayeuxContext != null) {
            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(
                            bayeuxContext.getUserPrincipal(), null
                    )
            );
        }
    }
}