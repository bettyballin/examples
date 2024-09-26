import javax.xml.ws.Endpoint;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.message.Message;

public class Temp240 {

    public static void main(String[] args) {
        // Dummy service implementation
        Object service = new Object();

        // Interceptors
        Interceptor<? extends Message> interceptor1 = new LoggingInInterceptor();
        Interceptor<? extends Message> interceptor2 = new LoggingInInterceptor();

        EndpointImpl ep1 = (EndpointImpl) Endpoint.publish("/endpoint1", service);
        ep1.getServer().getEndpoint().getInInterceptors().add(interceptor1);

        EndpointImpl ep2 = (EndpointImpl) Endpoint.publish("/endpoint2", service);
        ep2.getServer().getEndpoint().getInInterceptors().add(interceptor2);
    }
}