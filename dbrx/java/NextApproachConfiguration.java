import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class NextApproachConfiguration {

    @Bean
    public UserDetailsService inMemoryUserDetailsManager() {
        return new CustomInMemoryUserDetailsManager();
    }

    private static class CustomInMemoryUserDetailsManager extends InMemoryUserDetailsManager {

        public CustomInMemoryUserDetailsManager() {
            super(new User[0]);
        }

        public void addUser(UserDetails user) {
            super.createUser(user);
        }
    } 
}

// Main class to run the Spring application
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}