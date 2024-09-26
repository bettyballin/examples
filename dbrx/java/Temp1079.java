import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration
public class Temp1079 {

    public static void main(String[] args) {
        // Spring Boot typically runs in an application context, so the main method is often used to launch the app
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Temp1079.class);
        System.out.println("Temp1079 application has started.");
        context.close();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}