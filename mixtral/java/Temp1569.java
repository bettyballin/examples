import org.springframework.security.core.annotation.AuthenticationPrincipal;

public class Temp1569 {
    public static void main(String[] args) {
        // This main method is just a placeholder and won't execute the home method
    }

    public UserView home(@AuthenticationPrincipal User principal) {
        return principal != null ? new UserView(principal) : null;
    }
}

class User {
    // Define User class properties and methods here
}

class UserView {
    private User user;

    public UserView(User user) {
        this.user = user;
    }

    // Define UserView class properties and methods here
}