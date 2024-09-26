import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YourConfigClass {
    // Your configuration beans go here
}

public class Main {
    public static void main(String[] args) {
        // Load the Spring context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(YourConfigClass.class);
        
        // Your application logic goes here
        
        // Close the context
        context.close();
    }
}