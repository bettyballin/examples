import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(SomeControllerItTest.class)
public abstract class AbstractControllerIT {

    @MockBean
    protected JwtAuthenticationProvider jwtAuthenticatonProvider;

    @MockBean
    protected UserDetailsServiceImpl userDetailsService;

    // other mocks
}

@WebMvcTest(SomeControllerItTest.class)
class SomeControllerItTest extends AbstractControllerIT {

     @Autowired
     private MockMvc mockMvc;

     @MockBean
     private RegistrationService registrationService;

     @Test
     void shouldConfirmRegistration() {
         // Test implementation
     }
}