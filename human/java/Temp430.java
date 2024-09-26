import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class Temp430 {

    public static void main(String[] args) {
        // Mock privileged user authentication
        Authentication privilegedUser = new UsernamePasswordAuthenticationToken("privilegedUser", "password");
        SecurityContextHolder.getContext().setAuthentication(privilegedUser);

        // Mock BanService and User
        BanService banService = new BanService();
        User user = new User("user123");

        // Get ban for user
        Ban userBan = banService.getBanForUser(user);
        System.out.println("Ban Details: " + userBan);

        // Clear authentication
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}

// Mock classes for BanService, User, and Ban
class BanService {
    public Ban getBanForUser(User user) {
        return new Ban("Ban for user: " + user.getUsername());
    }
}

class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

class Ban {
    private String details;

    public Ban(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return details;
    }
}