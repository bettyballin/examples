import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main84 {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(IocConfig.class); // Registering the configuration class.
            context.refresh(); // Now Spring knows where to scan for beans.
            
            // Use the context here...
        }
    }
}