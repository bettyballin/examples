import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class Temp1142 {
    public static void main(String[] args) {
        // Create a JAX-WS proxy factory bean
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(MyServiceInterface.class);
        factory.setAddress("http://localhost:8080/myService");

        // Create the client proxy
        MyServiceInterface client = (MyServiceInterface) factory.create();

        // Create and configure the logging interceptor
        LoggingInInterceptor loggingInInterceptor = new LoggingInInterceptor();
        loggingInInterceptor.setPrettyLogging(true);
        factory.getInInterceptors().add(loggingInInterceptor);

        // Invoke a method on the client proxy
        client.someMethod();
    }
}

interface MyServiceInterface {
    void someMethod();
}