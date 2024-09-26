import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.transaction.Transactional;

@Service
public class UserServiceImpl1 implements UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    @Autowired
    public UserServiceImpl1(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    @Transactional
    public User registerNewUser(String username, String password) {
        // Assume User is an entity and user registration logic goes here
        // Also assume that this method signature matches the one in UserService interface
        // This is a placeholder for the actual user registration logic
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        // ... more user setup code ...

        userRepository.save(newUser);
        return newUser;
    }

    // Other methods from the UserService interface must be implemented here
}