import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

class SecurityConfig {
    private String role;

    public SecurityConfig(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

@Configuration
@Profile("dev")
class ApplicationDevConfig {
    @Bean
    public SecurityConfig securityConfig() {
        return new SecurityConfig("DEV_ROLE");
    }
}

@Configuration
@Profile("prod")
class ApplicationProdConfig {
    @Bean
    public SecurityConfig securityConfig() {
        return new SecurityConfig("PROD_ROLE");
    }
}

// Main application to demonstrate the profiles (for testing purposes)
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = { ApplicationDevConfig.class, ApplicationProdConfig.class })
public class Application {
    public static void main(String[] args) {
        // Set the active profile programmatically for demonstration
        System.setProperty("spring.profiles.active", "dev"); // Change to "prod" to test prod profile

        ApplicationContext context = SpringApplication.run(Application.class, args);

        SecurityConfig securityConfig = context.getBean(SecurityConfig.class);
        System.out.println("Active Profile Role: " + securityConfig.getRole());
    }
}