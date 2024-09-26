import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired    
    private ObjectMapper objectMapper;

    @Autowired    
    private MyService myService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, 
                                        HttpServletResponse response, 
                                        Authentication authentication)
    throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        AbstractUser currentUser = myService.userForClient();

        response.getOutputStream().print(
            objectMapper.writeValueAsString(currentUser));

        clearAuthenticationAttributes(request);
    }
}

// Assuming MyService and AbstractUser are defined elsewhere in your codebase.
// Example stubs for completeness:

import org.springframework.stereotype.Service;

@Service
class MyService {
    public AbstractUser userForClient() {
        return new AbstractUser(); // Replace with actual logic
    }
}

class AbstractUser {
    // Define fields and methods
}