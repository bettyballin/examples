import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class Temp813 {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(MyServiceInterface.class);
        factory.setAddress("http://localhost:8080/myService");

        MyServiceInterface client = (MyServiceInterface) factory.create();

        client.getOutInterceptors().add(new LoggingOutInterceptor());
        client.getInInterceptors().add(new LoggingInInterceptor());
        
        // Call a method on the client to test
        // client.someMethod();
    }

    interface MyServiceInterface {
        // Define methods for the service interface
        // void someMethod();
    }
}