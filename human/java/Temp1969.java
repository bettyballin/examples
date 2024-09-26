import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.message.Message;

import java.util.List;

public class Temp1969 {
    public static void main(String[] args) {
        // Create a factory for the client
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        // Set the service class and address
        factory.setServiceClass(MyServiceInterface.class);
        factory.setAddress("http://localhost:8080/myService");

        // Create the client
        MyServiceInterface client = (MyServiceInterface) factory.create();

        // Create and add interceptors
        LoggingOutInterceptor clearOutputLogger = new LoggingOutInterceptor();
        LoggingInInterceptor clearInputLogger = new LoggingInInterceptor();
        client.getOutInterceptors().add(clearOutputLogger);
        client.getInInterceptors().add(clearInputLogger);

        // Call the service method
        client.myServiceMethod();
    }
}

interface MyServiceInterface {
    void myServiceMethod();
}