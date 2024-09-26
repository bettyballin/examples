import org.springframework.boot.SpringApplication2;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableAutoConfiguration
@ComponentScan
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class Application2 {

   public static void main(String[] args) {
       SpringApplication2.run(Application2.class, args);
   }
}