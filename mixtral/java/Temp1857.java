import java.util.HashMap;
import java.util.Map;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.apache.wss4j.dom.WSSecurityConstants;

public class Temp1857 {
    public static void main(String[] args) {
        Map<String, Object> props = new HashMap<>();
        props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        props.put(WSHandlerConstants.PASSWORD_TYPE, WSSecurityConstants.PW_TEXT);

        WSS4JInInterceptor wss4jInInterceptor = new WSS4JInInterceptor(props);
        // Assuming 'endpoint' is a previously defined CXF endpoint
        // endpoint.getInInterceptors().add(wss4jInInterceptor);
    }
}