import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {
    @Bean
    public PasswordEncoder passwordEncoder()  {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PasswordEncoderConfig.class);
        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
        String encodedPassword = encoder.encode("mySecretPassword");
        System.out.println("Encoded Password: " + encodedPassword);
        context.close();
    }
}