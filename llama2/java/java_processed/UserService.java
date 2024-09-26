import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Define UserRepository interface
interface UserRepository {
    void updateRole(String role, Long userId);
}

// Implement UserRepository for demonstration purposes
class UserRepositoryImpl implements UserRepository {
    @Override
    public void updateRole(String role, Long userId) {
        // Mock implementation for demonstration
        System.out.println("Updated user with ID " + userId + " to role " + role);
    }
}

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void updateRole(Long userId, String role) {
        userRepository.updateRole(role, userId);
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        // Simulate Spring's dependency injection
        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserService();
        userService.userRepository = userRepository;

        // Call the method to update role
        userService.updateRole(1L, "ADMIN");
    }
}