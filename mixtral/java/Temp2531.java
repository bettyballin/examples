import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Temp2531 {
    public static void main(String[] args) {
        // Main method is empty because the Bean is defined for Spring context
    }

    @Bean
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }
}