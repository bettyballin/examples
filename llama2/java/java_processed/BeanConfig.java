import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ejb.EJB;

@Configuration
public class BeanConfig {

    @EJB
    private CollaborateurFacade collaborateurFacade;

    @Bean
    public CollaborateurFacade getCollaborateurFacade() {
        return collaborateurFacade;
    }

    // Mock CollaborateurFacade class for demonstration purposes
    public static class CollaborateurFacade {
        // Add methods and properties as needed
    }

    // Main method to test the configuration
    public static void main(String[] args) {
        org.springframework.context.annotation.AnnotationConfigApplicationContext context =
                new org.springframework.context.annotation.AnnotationConfigApplicationContext(BeanConfig.class);

        CollaborateurFacade facade = context.getBean(CollaborateurFacade.class);
        System.out.println("CollaborateurFacade bean: " + facade);
        context.close();
    }
}