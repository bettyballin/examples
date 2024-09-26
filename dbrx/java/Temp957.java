import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import java.util.HashMap;
import java.util.Map;

public class Temp957 {
    public static void main(String[] args) {
        Map<String, Object> props = new HashMap<>();
        props.put(WSHandlerConstants.ACTION, WSHandlerConstants.SIGNATURE);
        props.put(WSHandlerConstants.SIG_PROP_FILE, "path/to/your/signature.properties");
        props.put(WSHandlerConstants.USER, "your-username");

        WSS4JOutInterceptor wss4j = new WSS4JOutInterceptor(props);

        // You might want to add this interceptor to a CXF client or endpoint
        // For example:
        // Client client = ClientProxy.getClient(proxy);
        // client.getOutInterceptors().add(wss4j);
    }
}