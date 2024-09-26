import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.RuntimePermission;

public class PermissionsSnippet {
    public static void main(String[] args) {
        PermissionCollection permissions = new Permissions();
        permissions.add(new RuntimePermission("getClassLoader"));
        permissions.add(new RuntimePermission("setContextClassLoader"));
    }
}