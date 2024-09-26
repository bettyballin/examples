import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Temp1671 {
    
    @Autowired
    @Lazy
    private UserDetailsService userDetailsService;

    public static void main(String[] args) {
        // Create the application context
        org.springframework.context.ApplicationContext context = 
            new org.springframework.context.annotation.AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the bean
        Temp1671 temp = context.getBean(Temp1671.class);
    }
}

// Dummy UserDetailsService interface to make the code executable
interface UserDetailsService {
    void someMethod();
}

// Configuration class to register beans
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example"}) // Assuming Temp1671 is in com.example package
class AppConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public void someMethod() {
                System.out.println("Some method implemented");
            }
        };
    }
}