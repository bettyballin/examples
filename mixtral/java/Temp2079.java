import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.UserDetails;
import java.security.Principal;

@RestController
public class Temp2079 {
    public static void main(String[] args) {
        // Spring Boot application would be started here
    }

    @GetMapping("/some-endpoint")
    public ResponseEntity<SomeResponse> someMethod(Principal principal) {
        String username = ((UserDetails) principal).getUsername();

        // use the extracted username to fetch user details from database
        return ResponseEntity.ok(new SomeResponse(username));
    }
}

class SomeResponse {
    private String username;

    public SomeResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}