import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class Temp3594 {
    public static void main(String[] args) {
        // You can call the login method here if needed
    }

    public ResponseEntity<String> login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        // For demonstration purposes, let's just return a simple message
        return ResponseEntity.ok("Login successful for user: " + username);
    }
}