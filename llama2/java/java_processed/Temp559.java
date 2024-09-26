import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;

public class Temp559 {
    public static void main(String[] args) {
        // Your main method implementation here
    }

    public interface IUserService {
        @Secured(SecurityConstants.getRoles())
        ResponseEntity saveUser(CreateUserDtoRequest userDto);
    }

    // Dummy classes to make the code executable
    public static class SecurityConstants {
        public static String[] getRoles() {
            return new String[]{"ROLE_USER"};
        }
    }

    public static class CreateUserDtoRequest {
        // Fields and methods for CreateUserDtoRequest
    }
}