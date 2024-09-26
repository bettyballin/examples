import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@ExtendWith(MockitoExtension.class)
@WebMvcTest
public class Temp1676 {

    private static final String BASE_URL = "/api/users";
    private static final String TEST_USER_ID = "123";

    private MockMvc mockMvc;

    @Mock
    private SecurityService securityService;

    @MockBean
    private TestService testService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testFetchUserData() throws Exception {
        when(securityService.hasAccessToUser(anyString())).thenReturn(true);

        mockMvc.perform(get(BASE_URL + "/" + TEST_USER_ID))
                .andExpect(status().isOk());

        verify(testService).fetchUserData(TEST_USER_ID);
    }
}

// Assuming these classes are defined somewhere in your project:
class SecurityService {
    public boolean hasAccessToUser(String userId) {
        // Implementation here
        return true;
    }
}

class TestService {
    public void fetchUserData(String userId) {
        // Implementation here
    }
}

@RestController
class UserController {
    private final SecurityService securityService;
    private final TestService testService;

    public UserController(SecurityService securityService, TestService testService) {
        this.securityService = securityService;
        this.testService = testService;
    }

    @GetMapping("/api/users/{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId) {
        if (securityService.hasAccessToUser(userId)) {
            testService.fetchUserData(userId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}