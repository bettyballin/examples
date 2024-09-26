class Role {
    private String name;
    
    public Role(String name) {
        this.name = name;
    }

    public boolean hasPermission(String permission) {
        // Mock method to simulate permission check
        return "admin".equals(this.name) && "read".equals(permission);
    }
}

class ShiroRealm {
    public Role getRole(String roleName) {
        // Mock method to return a Role object
        return new Role(roleName);
    }
}

class Shiro {
    private ShiroRealm realm = new ShiroRealm();

    public ShiroRealm getRealm() {
        return realm;
    }
}

public class Temp103 {
    private Shiro shiro;

    public Temp103() {
        shiro = new Shiro();
    }

    public boolean roleHasPermission(String roleName, String permission) {
        // Get the desired role
        Role role = shiro.getRealm().getRole(roleName);

        if (role == null) return false;

        // Check for the specified permission
        return role.hasPermission(permission);
    }

    public static void main(String[] args) {
        Temp103 temp = new Temp103();
        System.out.println(temp.roleHasPermission("admin", "read")); // should print true
        System.out.println(temp.roleHasPermission("user", "read"));  // should print false
    }
}