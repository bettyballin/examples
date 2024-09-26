import java.util.ArrayList;
import java.util.List;

class Permission {
    private String name;

    public Permission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Role {
    private List<Permission> permissions;

    public Role() {
        this.permissions = new ArrayList<>();
    }

    public void addPermission(Permission permission) {
        this.permissions.add(permission);
    }

    public List<Permission> getPermissions() {
        return permissions;
    }
}

class GrantedAuthorityImpl {
    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return authority;
    }
}

public class Temp211 {
    public static void main(String[] args) {
        List<GrantedAuthorityImpl> permissions = new ArrayList<>();
        Role role = new Role();
        role.addPermission(new Permission("READ"));
        role.addPermission(new Permission("WRITE"));

        for (Permission permission : role.getPermissions()) {
            permissions.add(new GrantedAuthorityImpl(permission.getName()));
        }

        for (GrantedAuthorityImpl permission : permissions) {
            System.out.println(permission);
        }
    }
}