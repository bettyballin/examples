import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.endpoint.Client;

public class Temp814 {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(MyService.class);
        factory.setAddress("http://example.com/myService");

        MyService service = (MyService) factory.create();
        Client client = org.apache.cxf.frontend.ClientProxy.getClient(service);

        client.getOutInterceptors().add(new LoggingOutInterceptor());
        ((LoggingOutInterceptor) client.getOutInterceptors().get(0)).setPrettyLogging(true);
    }
}

interface MyService {
    // Define service methods here
}