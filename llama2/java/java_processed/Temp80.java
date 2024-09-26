import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Temp80 {
    // Dummy User and UserService classes for demonstration purposes
    static class User {
        private String username;
        private String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    static class UserService {
        public User getUserByUsername(String username) {
            // Simulate user retrieval
            return new User(username, "password123");
        }
    }

    private static UserService userService = new UserService();

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        // Authenticate user
        User user = userService.getUserByUsername(username);
        if (!user.getPassword().equals(password)) {
            return "login";
        }

        // Set session attribute
        request.getSession().setAttribute("jsessionid", UUID.randomUUID().toString());

        // Redirect to home page
        return "redirect:/users";
    }

    public static void main(String[] args) {
        // This main method is just a placeholder and does nothing in this context
        System.out.println("Temp80 class with login method.");
    }
}