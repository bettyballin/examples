import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        // Creating an ApplicationContext to load the AppConfig
        org.springframework.context.ApplicationContext context = 
                new org.springframework.context.annotation.AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieving the BCryptPasswordEncoder bean
        BCryptPasswordEncoder encoder = context.getBean(BCryptPasswordEncoder.class);

        // Testing the encoder
        String password = "myPassword";
        String encodedPassword = encoder.encode(password);
        System.out.println("Encoded password: " + encodedPassword);

        // Verify the password
        boolean matches = encoder.matches(password, encodedPassword);
        System.out.println("Password matches: " + matches);
    }
}