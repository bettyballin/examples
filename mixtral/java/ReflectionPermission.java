import java.security.AccessControlException;
import java.security.BasicPermission;
import java.security.Permission;

public final class ReflectionPermission extends BasicPermission {
    public ReflectionPermission(String name) {
        super(name);
    }

    // You might want to add more specific permissions here
}

class CustomSecurityManager extends SecurityManager {
    @Override
    public void checkPermission(Permission perm) throws AccessControlException {
        if (perm instanceof ReflectionPermission) {
            throw new AccessControlException("Reflection is not allowed");
        }

        // Call super for other permission checks
        super.checkPermission(perm);
    }
}

public class Main {
    public static void main(String[] args) {
        System.setSecurityManager(new CustomSecurityManager());

        try {
            ReflectionPermission reflectionPermission = new ReflectionPermission("reflectionPermission");
            System.getSecurityManager().checkPermission(reflectionPermission);
        } catch (AccessControlException e) {
            System.out.println(e.getMessage());
        }
    }
}