import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class Temp1197 {

    private final UserRepository userRepository;

    public Temp1197(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        // This main method is included to make the class executable, but it does not perform any operations.
    }

    @Transactional
    public UserDetails loadUserByUsername(String email, String companyId) throws UsernameNotFoundException {
        User user = userRepository.findByEmailAndCompanyId(email, companyId).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found with  -> username or email and company id : " + email));
        return UserPrinciple.build(user);
    }

    // Dummy UserRepository for the sake of this example
    interface UserRepository {
        java.util.Optional<User> findByEmailAndCompanyId(String email, String companyId);
    }

    // Dummy User and UserPrinciple classes for the sake of this example
    static class User {
        // User properties and methods would go here
    }

    static class UserPrinciple {
        static UserDetails build(User user) {
            // Build and return UserDetails instance based on provided user
            return null; // This should be replaced with actual UserDetails implementation
        }
    }
}