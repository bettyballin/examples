import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

@WebMvcTest(UserCommandService.class)
@Import(TestConfig.class)
class UserCommandServiceTest {

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
        Long userId = 1L;
        User userMocked = new User(userId, "user", "test", "user@gmail.com", "123456", "user@gmail.com", "basic");
        UserCreateDto userCreateDto = new UserCreateDto("user", "test", "user@gmail.com", "123456", "user@gmail.com", "basic");

        when(userRepository.save(any(User.class))).thenReturn(userMocked);

        UserCreateDto createdUser = userCommandService.createUser(userCreateDto);
        assertEquals(userMocked.getPassword(), createdUser.getPassword());
    }
}