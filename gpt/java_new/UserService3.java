import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

@Service
public class UserService3 {

    @PostAuthorize("returnObject.username == authentication.name")
    public User getUserProfile(String username) {
        // retrieve the user profile
        User user = findUserByUsername(username); // this should be your actual user retrieval logic
        return user;
    }
    
    // Mock method to represent user retrieval, replace with actual implementation
    private User findUserByUsername(String username) {
        // your database access logic to find user by username
        return new User(username); // replace with actual user retrieval code
    }
    
    // Mock User class for the example, replace with actual User class
    public static class User {
        private String username;
        
        public User(String username) {
            this.username = username;
        }
        
        public String getUsername() {
            return username;
        }
    }
}