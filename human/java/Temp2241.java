import java.io.FilePermission;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.Policy;
import java.security.ProtectionDomain;

public class Main {
    public static void main(String[] args) {
        Policy.setPolicy(new CustomPolicy());
        System.setSecurityManager(new SecurityManager());
        
        // Test code that requires the specified permission
        try {
            Class<?> clazz = Class.forName("java.lang.String");
            clazz.getDeclaredField("value");
            System.out.println("Permission granted: Access to private field allowed.");
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}

class CustomPolicy extends Policy {
    @Override
    public PermissionCollection getPermissions(ProtectionDomain domain) {
        Permissions permissions = new Permissions();
        permissions.add(new java.lang.reflect.ReflectPermission("suppressAccessChecks"));
        return permissions;
    }
}