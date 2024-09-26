import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class Temp626 {

    public static void main(String[] args) {
        // SpringApplication.run(Temp626.class, args); // Uncomment this if you have a Spring Boot application
        new Temp626().configureServices();
    }

    @Bean
    public AttributeRepository attributeRepository() {
        return new DefaultAttributeRepository();
    }

    @Autowired
    private ServiceRegistryDao serviceRegistry;

    @PostConstruct
    protected void configureServices() {
        try {
            RegisteredService testRegisteredService = registeredServiceTest(
                    "https://localhost:8180/j_spring_cas_security_check");

            AttributeReleasePolicy attributeReleasePolicy = new RegexRegisteredServiceAccessStrategy();

            // Add the attributes you want to release
            ((RegexRegisteredServiceAccessStrategy) attributeReleasePolicy).setAllowedAttributes(Arrays.asList("*"));

            testRegisteredService.setAttributeReleasePolicy(attributeReleasePolicy);

            serviceRegistry.save(testRegisteredService);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private RegisteredService registeredServiceTest(String url) {
        // TODO: Implement this method
        return new RegisteredService();
    }

    // Dummy classes to make the code compile
    private class DefaultAttributeRepository implements AttributeRepository {
    }

    private interface AttributeRepository {
    }

    private interface ServiceRegistryDao {
        void save(RegisteredService registeredService);
    }

    private class RegisteredService {
        void setAttributeReleasePolicy(AttributeReleasePolicy attributeReleasePolicy) {
        }
    }

    private class RegexRegisteredServiceAccessStrategy implements AttributeReleasePolicy {
        void setAllowedAttributes(java.util.List<String> attributes) {
        }
    }

    private interface AttributeReleasePolicy {
    }
}