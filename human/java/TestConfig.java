import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@TestConfiguration
public class TestConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    public static void main(String[] args) {
        org.springframework.context.annotation.AnnotationConfigApplicationContext context = 
            new org.springframework.context.annotation.AnnotationConfigApplicationContext(TestConfig.class);
        
        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
        System.out.println("Encoded password: " + encoder.encode("password"));
    }
}