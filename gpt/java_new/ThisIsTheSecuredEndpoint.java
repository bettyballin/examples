import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;
import javax.websocket.CloseReason;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import javax.websocket.OnOpen;
import javax.websocket.server.PathParam;

@ServerEndpoint("/user/endpoint/{token}")
public class ThisIsTheSecuredEndpoint {

    @EJB
    private TokenService tokenService;

    @OnOpen
    public void onOpen(@PathParam("token") String incomingToken, Session session) throws IOException {

        boolean isValid = tokenService.verifyToken(incomingToken);
        if (!isValid) {
            session.close(new CloseReason(CloseReason.CloseCodes.VIOLATED_POLICY, "Invalid token"));
        }

        // Proceed with opening the WebSocket connection
    }
}

@Stateless
public class TokenService {

    public boolean verifyToken(String token) {
        // Implement token verification logic here.
        // It could check the token signature, expiration, and associated user session.
        return true; // return true if valid, false otherwise
    }
}