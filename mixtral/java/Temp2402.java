import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class Temp2402 {

    // Assuming User class is defined elsewhere in the project
    public static class User {
        private String username;

        public User(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

    public void someControllerMethod(User user) {
        String currentUser = user.getUsername();
    }

    @GetMapping("/some-url")
    public ResponseEntity<String> getSomeData(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();

        if (principal != null) {
            String currentUserName = principal.getName();
            return ResponseEntity.ok("Logged in user: " + currentUserName);
        } else {
            return ResponseEntity.ok("No user is logged in");
        }
    }

    public static void main(String[] args) {
        // This main method is just a placeholder and won't actually run the Spring Boot application.
        // To run this as a Spring Boot application, you need to have a Spring Boot setup and run it accordingly.
        System.out.println("Temp2402 class loaded.");
    }
}