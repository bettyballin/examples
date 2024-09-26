import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RegistrationService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public RegistrationService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User register(String username, String password, String firstName, String lastName, String email) {
        if (userRepository.findByUsername(username).isEmpty()) {
            User user = new User(username, bCryptPasswordEncoder.encode(password), firstName, lastName, email);
            user.grantRole(UserRole.ROLE_USER);
            userRepository.save(user);
            return user;
        } else {
            throw new RuntimeException("User already exists");
        }
    }
}