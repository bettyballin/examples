import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp1939 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1939.class, args);
    }

    @RestController
    @RequestMapping("/api")
    public static class UserController {

        @GetMapping("/user")
        public String getUser(@AuthenticationPrincipal YourCustomUserDetailsClass user) {
            // use the 'user' object to access logged-in user details
            return "User details: " + user.toString();
        }
    }

    public static class YourCustomUserDetailsClass {
        private String username;

        // other fields, getters, setters, etc.

        @Override
        public String toString() {
            return "YourCustomUserDetailsClass{" +
                    "username='" + username + '\'' +
                    '}';
        }
    }
}