import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Temp1825 {

    public static void main(String[] args) {
        // Spring Boot applications typically start with SpringApplication.run()
        // Uncomment the line below for a Spring Boot application:
        // SpringApplication.run(Temp1825.class, args);
    }

    @Bean
    public SecurityConfig basicConfig(@Value("${authentication.type.oauth}") boolean isOauthEnabled) {
        if (isOauthEnabled) {
            return new ResourceServerSecurityConfig();
        } else {
            return new BasicSecurityConfig();
        }
    }
}

class SecurityConfig {
    // Add appropriate members and methods here
}

class ResourceServerSecurityConfig extends SecurityConfig {
    // Add appropriate members and methods here
}

class BasicSecurityConfig extends SecurityConfig {
    // Add appropriate members and methods here
}