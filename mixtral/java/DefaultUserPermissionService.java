import java.util.List;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Define the UserDetails class
class UserDetails {
    private Long id;

    public UserDetails(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

// Define the Role class
class Role {
    private boolean showSuppliers;

    public Role(boolean showSuppliers) {
        this.showSuppliers = showSuppliers;
    }

    public boolean getShowSuppliers() {
        return showSuppliers;
    }
}

// Define the RoleRepository interface
interface RoleRepository {
    List<Role> findByUserId(Long userId);
}

// Define the UserPermissionService interface
public interface UserPermissionService {
    boolean canAccessSupply(UserDetails user);
}

@Service
public class DefaultUserPermissionService implements UserPermissionService {

    @Autowired
    private RoleRepository roleRepo;

    @Override
    public boolean canAccessSupply(UserDetails user) {
        // Assuming you have a way to get the roles of the current logged-in user
        List<Role> roles = roleRepo.findByUserId(user.getId());
        return roles.stream().anyMatch(role -> BooleanUtils.isTrue(role.getShowSuppliers()));
    }
}

// Mock RoleRepository for testing purposes
class MockRoleRepository implements RoleRepository {
    @Override
    public List<Role> findByUserId(Long userId) {
        // Return some mock data
        return List.of(new Role(true), new Role(false));
    }
}

// Main class to test the service
public class Main {
    public static void main(String[] args) {
        RoleRepository roleRepo = new MockRoleRepository();
        DefaultUserPermissionService userPermissionService = new DefaultUserPermissionService();
        // Manually set the roleRepo since we are not using Spring context here
        userPermissionService.roleRepo = roleRepo;

        UserDetails user = new UserDetails(1L);
        boolean canAccess = userPermissionService.canAccessSupply(user);
        System.out.println("Can access supply: " + canAccess);
    }
}