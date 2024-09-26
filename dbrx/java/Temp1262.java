import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class Temp1262 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1262.class, args);
    }

    @RestController
    public static class UserController {
        
        @PostMapping("/log-in")
        public ResponseEntity<String> logIn(@RequestBody UserDto userDto) {
            // Placeholder for actual logic
            return ResponseEntity.ok("Logged in");
        }
    }

    public static class UserDto {
        private String username;
        private String password;

        // Getters and Setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}