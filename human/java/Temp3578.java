//---------------------------------------------------//
// Test secured @Component which isn't a @Controller //
//---------------------------------------------------//

// Import necessary dependencies
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

// SampleApi.WebSecurityConfig and MessageService classes need to be implemented as per the application's requirements

// Import web-security configuration and tested component class
@Import({ SampleApi.WebSecurityConfig.class, MessageService.class })
@ExtendWith(SpringExtension.class)
@SpringBootTest
class MessageServiceTests {

    // Auto-wire tested component
    @Autowired
    private MessageService messageService;

    // Mock tested component dependencies
    @MockBean
    GreetingRepo greetingRepo;
    
    @BeforeEach
    public void setUp() {
        when(greetingRepo.findUserSecret("ch4mpy")).thenReturn("Don't tel it");
    }

    @Test
    void greetWitoutAuthentication() {
        // Call tested component methods directly (don't use MockMvc nor WebTestClient)
        assertThrows(Exception.class, () -> messageService.getSecret("ch4mpy"));
    }

    @Test
    @WithMockUser(roles = "AUTHORIZED_PERSONNEL", username = "ch4mpy")
    void greetWithMockJwtAuth() {
        assertThat(messageService.getSecret("ch4mpy")).isEqualTo("Don't tel it");
    }
}

// Mocking MessageService and GreetingRepo for demonstration purposes

class MessageService {
    @Autowired
    private GreetingRepo greetingRepo;

    public String getSecret(String username) throws Exception {
        // Simulate security check
        if (!"AUTHORIZED_PERSONNEL".equals("ROLE_AUTHORIZED_PERSONNEL")) {
            throw new Exception("Unauthorized");
        }
        return greetingRepo.findUserSecret(username);
    }
}

interface GreetingRepo {
    String findUserSecret(String username);
}

// SampleApi.WebSecurityConfig needs to be implemented as per application's security requirements
class SampleApi {
    static class WebSecurityConfig {
        // Security configuration goes here
    }
}