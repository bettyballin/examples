import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

@Import({TestConfig.class})
@WebMvcTest(UserCommandService.class)
public class UserCommandServiceTest {

    @MockBean
    UserRepository userRepository;

    @Autowired
    private UserCommandService userCommandService;

    @MockBean
    private MyUserDetailsService myUserDetailsService;

    @MockBean
    private JwtUtil jwtUtil;

    @Test
    void testCreateUser() {
        final long userId = 1L; // Assuming the id is of type long
        User userMocked = new User(userId, "user", "test", "user@gmail.com", "123456", "user@gmail.com", "basic");
        UserCreateDto userCreateDto = new UserCreateDto("user", "test", "user@gmail.com", "123456", "user@gmail.com", "basic");

        when(userRepository.save(any(User.class))).thenReturn(userMocked);

        UserCreateDto createdUser = userCommandService.createUser(userCreateDto);
        assertEquals(userMocked.getPassword(), createdUser.getPassword());
    }
}