import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Temp1242 {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(Temp1242.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            saveUser("username", "rawPassword");
        };
    }

    public void saveUser(String username, String rawPassword) {
        User user = new User();
        // Assuming User class has a setUsername and setPassword method
        user.setUsername(username);

        String encodedPassword = this.passwordEncoder.encode(rawPassword);
        user.setPassword(encodedPassword);

        // Assuming repository is properly defined and autowired
        repository.save(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Dummy repository and User class for the sake of completeness
    @Autowired
    private UserRepository repository;

    interface UserRepository {
        void save(User user);
    }

    class User {
        private String username;
        private String password;

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}