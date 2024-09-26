import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.endpoint.Client;

public class Temp1141 {
    public static void main(String[] args) {
        // Create a JAX-WS proxy factory
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(SomeWebServiceInterface.class);
        factory.setAddress("http://example.com/webservice");

        // Create the client
        SomeWebServiceInterface client = (SomeWebServiceInterface) factory.create();

        // Get the CXF Client
        Client cxfClient = org.apache.cxf.frontend.ClientProxy.getClient(client);

        // Add the LoggingOutInterceptor
        LoggingOutInterceptor loggingOutInterceptor = new LoggingOutInterceptor();
        loggingOutInterceptor.setPrettyLogging(true);
        cxfClient.getOutInterceptors().add(loggingOutInterceptor);

        // Call a method on the web service
        client.someMethod();
    }

    // Dummy interface to represent the web service
    public interface SomeWebServiceInterface {
        void someMethod();
    }
}