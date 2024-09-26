import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public CurrentUserControllerAdvice currentUserControllerAdvice() {
        return new CurrentUserControllerAdvice();
    }

    public static void main(String[] args) {
        org.springframework.context.ApplicationContext context = 
            new org.springframework.context.annotation.AnnotationConfigApplicationContext(TestConfig.class);
        System.out.println(context.getBean(CurrentUserControllerAdvice.class));
    }
}

class CurrentUserControllerAdvice {
    // Assuming this class has some properties and methods
}