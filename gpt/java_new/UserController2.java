import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
public class UserController2 {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserView home(@AuthenticationPrincipal User principal) {
        // Assuming UserView class exists and has a constructor that takes a User object
        return new UserView(principal);
    }

    // UserView class definition (for example purposes)
    public class UserView {
        private String username;

        public UserView(User user) {
            this.username = user.getUsername(); // Assuming User class has getUsername method
        }

        // Getter and setter for username
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    // User class definition (for example purposes)
    public class User {
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}