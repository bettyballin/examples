import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Temp2296 {

    @Autowired
    private ServiceCore serviceCore;

    public static void main(String[] args) {
        // Initialize Spring Application Context to use @Autowired
        org.springframework.context.ApplicationContext context =
            new org.springframework.context.annotation.AnnotationConfigApplicationContext(Config.class);
        
        Temp2296 temp = context.getBean(Temp2296.class);
        temp.someMethod();
    }

    public void someMethod() {
        // Call methods on 'serviceCore'
    }
}

@Component
class ServiceCore {
    // Define methods and properties of ServiceCore
}

@Configuration
@ComponentScan(basePackages = "your.package.name")
class Config {
    // Configuration class for Spring
}