import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// Assuming RoleProperties is a configuration properties class
@Configuration
@EnableConfigurationProperties(RoleProperties.class)
class Config {
    @Bean
    @ConfigurationProperties(prefix = "role")
    public RoleProperties roleProperties() {
        return new RoleProperties();
    }
}

@Component
class RoleProperties {
    private String roleName;

    // getters and setters
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

@Service
public class YourService {

    @Autowired
    private RoleProperties roleProperties;

    // Method to demonstrate the usage of roleProperties
    public void printRoleName() {
        System.out.println("Role Name: " + roleProperties.getRoleName());
    }

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(Config.class, args);

        // Retrieve the YourService bean and call the printRoleName method
        YourService yourService = org.springframework.context.ApplicationContextProvider.getBean(YourService.class);
        yourService.printRoleName();
    }
}



import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// Utility class to get beans from ApplicationContext
@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }
}