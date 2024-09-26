import org.springframework.boot.actuate.audit.InMemoryAuditEventRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Temp3065 {
    public static void main(String[] args) {
        // In a real Spring application, the context would be initialized by Spring Boot
        // For demonstration purposes, we'll initialize the context manually
        org.springframework.context.annotation.AnnotationConfigApplicationContext context =
                new org.springframework.context.annotation.AnnotationConfigApplicationContext(Temp3065.class);
        
        // Retrieve the bean to verify it has been created
        InMemoryAuditEventRepository repository = context.getBean(InMemoryAuditEventRepository.class);
        System.out.println("Repository bean created: " + repository);
        
        context.close();
    }

    @Bean
    public InMemoryAuditEventRepository repository() {
        return new InMemoryAuditEventRepository();
    }
}