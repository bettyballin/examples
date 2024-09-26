import org.springframework.security.core.GrantedAuthority;
import java.util.List;
import java.util.ArrayList;

// Assuming the following custom classes and methods exist based on the provided snippet:
class Permission {
    public String getName() {
        // Implementation here
    }
}

class Role {
    public List<Permission> getPermissions() {
        // Implementation here
    }
}

class GrantedAuthorityImpl implements GrantedAuthority {
    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}

public class RefactoredSnippet {
    public List<GrantedAuthority> refactorSnippet(Role role) {
        List<GrantedAuthority> permissions = new ArrayList<>();
        for (Permission permission : role.getPermissions()) {
            permissions.add(new GrantedAuthorityImpl(permission.getName()));
        }
        return permissions;
    }
}