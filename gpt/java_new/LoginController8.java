import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoginController8 {

    private final RestTemplate restTemplate;

    @Autowired
    public LoginController8(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/loginUser")
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {
        String loginProcessingUrl = "/login"; // Change the URL to match your login processing URL
        ResponseEntity<?> response = restTemplate.postForEntity(loginProcessingUrl, new LoginPostData(email, password), ResponseEntity.class);
        return response;
    }

    static class LoginPostData {
        private String user;
        private String password;

        public LoginPostData(String email, String password) {
            this.user = email; // Change this from username to user
            this.password = password;
        }

        // Getters and Setters for user and password
    }
}