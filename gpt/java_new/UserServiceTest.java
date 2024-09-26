import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class UserServiceTest {
    
    @Autowired
    private UserCommandService userCommandService;
    
    @Autowired
    private UserRepository userRepository;
    
    private PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();

    @Test
    public void testCreateUser() {
        UserCreateDto userCreateDto = new UserCreateDto("user", "test", "user@gmail.com", "123");
        userCommandService.createUser(userCreateDto);
        // Rest of the test implementation
    }
}