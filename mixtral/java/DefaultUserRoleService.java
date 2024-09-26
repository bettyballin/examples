import java.util.Arrays;
import java.util.List;

public interface UserRoleService {
    List<String> getUserRoles(Long userId);
}

@Service
class DefaultUserRoleService implements UserRoleService {

    //@Autowired
    //private RoleRepository roleRepo; // Assuming RoleRepository is defined elsewhere

    @Override
    public List<String> getUserRoles(Long userId) {
        // Implement your logic to retrieve user roles from the database
        return Arrays.asList("ROLE_ADMIN1", "ROLE_ADMIN2");
    }
}

// Annotations to simulate Spring's @Service and @Autowired
@interface Service {}
@interface Autowired {}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        UserRoleService userRoleService = new DefaultUserRoleService();
        List<String> roles = userRoleService.getUserRoles(1L);
        System.out.println(roles);
    }
}