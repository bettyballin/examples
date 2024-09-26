import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class StandaloneApp {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            // Assume AppConfig is a class annotated with @Configuration
            // and it contains the bean definitions for the application
            context.register(AppConfig.class);
            context.refresh();
            
            AuthenticationManager authManager = context.getBean(AuthenticationManager.class);
            Authentication request = new UsernamePasswordAuthenticationToken("user", "password");
            Authentication result = authManager.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);
            
            // Continue with the business logic after successful authentication
        }
    }
}