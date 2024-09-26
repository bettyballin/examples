import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class RoleConstants {
    // Define constants or methods here
    public static final String ADMIN_ROLE = "ADMIN";
}

@Component
class YourService {
    @Autowired
    private RoleConstants roleConstants;

    public void printRole() {
        System.out.println("Role: " + RoleConstants.ADMIN_ROLE);
    }
}

@Configuration
@ComponentScan(basePackages = "your.package.name")
class AppConfig {

    @Bean
    public RoleConstants roleConstants() {
        return new RoleConstants();
    }
}

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        YourService yourService = context.getBean(YourService.class);
        yourService.printRole();
        context.close();
    }
}