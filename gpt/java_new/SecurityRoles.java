import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;

public class SecurityRoles {
    public static final String ROLE1 = "ROLE_ROLE1";
    public static final String ROLE2 = "ROLE_ROLE2";
}

interface IUserService {

    @Secured({SecurityRoles.ROLE1, SecurityRoles.ROLE2})
    ResponseEntity<?> saveUser(Object userDto); // Replace CreateUserDtoRequest with the actual type

}