import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController4 {

    @GetMapping("/authentication")
    public String testAuthentication(Authentication authentication) {
        UserDetailsStub userDetailsStub = UserDetailsStub.of((User) authentication.getPrincipal());
        return userDetailsStub.getUsername();
    }

    // Assuming UserDetailsStub is a predefined class with a static of method
    private static class UserDetailsStub {
        private final User user;

        private UserDetailsStub(User user) {
            this.user = user;
        }

        public static UserDetailsStub of(User user) {
            return new UserDetailsStub(user);
        }

        public String getUsername() {
            return user.getUsername();
        }
    }
}