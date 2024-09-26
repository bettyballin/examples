import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Component
@ConfigurationProperties(prefix = "spring.security")
public class SecurityProperties {

    private User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static class User {
        
        private String name;
        private String password;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        
    }
    
    public static void main(String[] args) {
        SecurityProperties properties = new SecurityProperties();
        properties.getUser().setName("bob");
        properties.getUser().setPassword("$2a$10$2T4wM24pGyHuLj12SI/rC.C1gkg4mLGTuzTse3choIVIOtlgsWmPC");
        
        System.out.println("Username: " + properties.getUser().getName());
        System.out.println("Password: " + properties.getUser().getPassword());
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode("password");
        System.out.println("Encoded password: " + encodedPassword);
    }
}