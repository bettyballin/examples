import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

public class Temp1814 {

    // Assume UserRepository is a defined interface
    private UserRepository userRepository;

    public Temp1814(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        // Example usage
        UserRepository userRepository = new InMemoryUserRepository(); // Example repository
        Temp1814 temp1814 = new Temp1814(userRepository);
        try {
            UserDetails user = temp1814.loadUserByUsername("example@example.com");
            System.out.println("User found: " + user.getUsername());
        } catch (UsernameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Extract companyId from Authentication object
        String companyId = ((OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication())
                .getOAuth2Request().getClientId();

        return userRepository.findByEmailAndCompanyId(email, Long.parseLong(companyId)).orElseThrow(() ->
                new UsernameNotFoundException("User Not Found with -> username or email : " + email));
    }
}

// Dummy UserRepository interface and implementation for demonstration purposes
interface UserRepository {
    java.util.Optional<UserDetails> findByEmailAndCompanyId(String email, Long companyId);
}

class InMemoryUserRepository implements UserRepository {
    @Override
    public java.util.Optional<UserDetails> findByEmailAndCompanyId(String email, Long companyId) {
        // Dummy implementation
        if ("example@example.com".equals(email) && companyId == 1) {
            return java.util.Optional.of(new org.springframework.security.core.userdetails.User(
                    "example@example.com", "password", new java.util.ArrayList<>()));
        } else {
            return java.util.Optional.empty();
        }
    }
}