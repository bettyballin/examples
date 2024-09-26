import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temp2523 {
    
    public static void main(String[] args) {
        // This main method is not necessary for a Spring Boot application, but it's here for completeness.
        // Normally, Spring Boot applications are started via a SpringBootApplication annotation.
    }

    @PostMapping("/login")
    public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {
        try {
            // Simulate JWT generation
            String jwt = "dummyJwtToken"; // Replace with actual JWT generation logic

            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt)
                    .build();

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    // Dummy class to simulate incoming credentials
    public static class AccountCredentials {
        private String username;
        private String password;

        // Getters and setters

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