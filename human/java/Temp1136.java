import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Temp1136 {
    public static void main(String[] args) {
        org.springframework.context.annotation.AnnotationConfigApplicationContext context = new org.springframework.context.annotation.AnnotationConfigApplicationContext(SpringConfig.class);
        // Use the context to get the bean and call the service
    }
}

@Configuration
class SpringConfig {

    @Bean
    public Bus cxf() {
        SpringBus bus = new SpringBus();
        bus.getFeatures().add(new LoggingFeature());
        return bus;
    }

    @Bean
    public MyService client() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(MyService.class);
        factory.setAddress("http://example.com/service");
        factory.setUsername("Username");
        factory.setPassword("Password");
        return (MyService) factory.create();
    }
}

interface MyService {
    // Define service methods here
}