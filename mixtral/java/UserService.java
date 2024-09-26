import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private String[] userRoles;

    public UserService(@Value("#{'${user_service_roles}'.split(',')}") String... roles) {
        this.userRoles = roles;
    }

    @Secured("@userRoles")
    public ResponseEntity<String> saveUser(CreateUserDtoRequest userDto) {
        // Your implementation here
        return ResponseEntity.ok("User saved successfully");
    }

    public static void main(String[] args) {
        // Example usage
        String roles = "ROLE_ADMIN,ROLE_USER";
        UserService userService = new UserService(roles.split(","));
        CreateUserDtoRequest userDto = new CreateUserDtoRequest();
        System.out.println(userService.saveUser(userDto));
    }
}

interface IUserService {
    ResponseEntity<String> saveUser(CreateUserDtoRequest userDto);
}

class CreateUserDtoRequest {
    // Your fields and methods here
}