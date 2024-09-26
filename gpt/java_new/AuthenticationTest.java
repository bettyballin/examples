import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

class UserDetailsStub implements org.springframework.security.core.userdetails.UserDetails {
    private String username;

    public UserDetailsStub(String username) {
        this.username = username;
    }

    // Implement all abstract methods...
}

public class AuthenticationTest {
    
    private MockMvc mvc; // Make sure to initialize this

    @Test
    public void testAuthentication() throws Exception {
        // Arrange
        Authentication authentication = mock(Authentication.class);
        UserDetails userDetails = new UserDetailsStub("username");
        when(authentication.getPrincipal()).thenReturn(userDetails);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Act & Assert
        mvc.perform(get("/pdps/authentication").secure(true)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Clear the context for next tests
        SecurityContextHolder.clearContext();
    }
}