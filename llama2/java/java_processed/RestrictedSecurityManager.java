import java.security.*;

public class RestrictedSecurityManager extends SecurityManager {
    private static int deny = 0;

    @Override
    public void checkPermission(Permission perm) {
        // Deny reflection permissions for untrusted code
        if (perm instanceof ReflectPermission) {
            String name = perm.getName();
            if (name.startsWith("reflect.") || name.equals("suppressAccessChecks")) {
                deny++;
                throw new SecurityException("Reflection permission denied: " + name);
            }
        }

        // Call the parent's checkPermission method
        super.checkPermission(perm);
    }

    public static void main(String[] args) {
        SecurityManager sm = new RestrictedSecurityManager();
        System.setSecurityManager(sm);

        try {
            ReflectPermission perm = new ReflectPermission("suppressAccessChecks");
            sm.checkPermission(perm);
        } catch (SecurityException e) {
            System.out.println("SecurityException caught: " + e.getMessage());
        }

        System.out.println("Denied permissions count: " + deny);
    }
}