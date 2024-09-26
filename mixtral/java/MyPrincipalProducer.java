import java.security.Principal;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;

@ApplicationScoped
public class MyPrincipalProducer {

    @Inject
    private SecurityContext securityContext;

    public Principal getCurrentUser() {
        return securityContext.getCallerPrincipal();
    }
    
    public static void main(String[] args) {
        // For testing purposes, we need a mock SecurityContext
        SecurityContext mockSecurityContext = new SecurityContext() {
            @Override
            public Principal getCallerPrincipal() {
                return new Principal() {
                    @Override
                    public String getName() {
                        return "testUser";
                    }
                };
            }

            @Override
            public boolean isCallerInRole(String role) {
                return false;
            }

            @Override
            public <T> T getUserPrincipal(Class<T> aClass) {
                return null;
            }
        };

        MyPrincipalProducer producer = new MyPrincipalProducer();
        producer.securityContext = mockSecurityContext; // Inject the mock manually

        Principal currentUser = producer.getCurrentUser();
        System.out.println("Current user: " + currentUser.getName());
    }
}