import java.util.Arrays;
import java.util.List;

class PermissionFactory {
    public Permission buildFromName(String name) {
        switch (name) {
            case "READ":
                return new Permission("READ");
            case "WRITE":
                return new Permission("WRITE");
            case "EXECUTE":
                return new Permission("EXECUTE");
            default:
                throw new IllegalArgumentException("Permission not found");
        }
    }
}

class Permission {
    private String name;

    public Permission(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class Temp1424 {
    public static void main(String[] args) {
        Object permission = "read"; // Example input
        PermissionFactory permissionFactory = new PermissionFactory();

        if (permission instanceof String) {
            String permString = (String) permission;
            Permission p;

            try {
                p = permissionFactory.buildFromName(permString);
            } catch (IllegalArgumentException notfound) {
                p = permissionFactory.buildFromName(permString.toUpperCase());
            }

            if (p != null) {
                List<Permission> permissions = Arrays.asList(p);
                System.out.println(permissions);
            }
        }
    }
}