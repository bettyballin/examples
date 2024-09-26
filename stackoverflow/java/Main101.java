import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main101 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);
        // Assuming IocConfig class is defined somewhere and has the necessary configuration annotations
        context.close();
    }
}

// Dummy IocConfig class for the sake of example
// Actual implementation should contain valid Spring configuration
class IocConfig {
}