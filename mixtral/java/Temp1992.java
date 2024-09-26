import java.util.HashMap;
import java.util.Map;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;

public class Temp1992 {

    public static void main(String[] args) {
        // Create a JAX-WS client
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(MyServiceInterface.class);
        factory.setAddress("http://localhost:8080/myService");

        MyServiceInterface client = (MyServiceInterface) factory.create();

        // Get the CXF client and endpoint
        Client proxy = ClientProxy.getClient(client);
        Endpoint cxfEndpoint = proxy.getEndpoint();

        // Add logging interceptors
        cxfEndpoint.getInInterceptors().add(new LoggingInInterceptor());
        cxfEndpoint.getOutInterceptors().add(new LoggingOutInterceptor());

        // Create WSS4JOutInterceptor with properties
        WSS4JOutInterceptor wss4jOut = new WSS4JOutInterceptor(getProperties());
        cxfEndpoint.getOutInterceptors().add(wss4jOut);

        // Call the service
        client.myServiceMethod();
    }

    private static Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("action", "UsernameToken Timestamp");
        properties.put("passwordType", "PasswordText");
        properties.put("user", getUserName());
        properties.put("signaturePropFile", "/path/to/your-keystore.properties");
        return properties;
    }

    private static String getUserName() {
        // Replace this with your logic to get the username
        return "myUsername";
    }

    interface MyServiceInterface {
        void myServiceMethod();
    }
}