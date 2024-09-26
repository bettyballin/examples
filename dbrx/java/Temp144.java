import java.security.AccessControlException;
import java.security.Permission;
import java.security.SecurityManager;

public class Temp144 {
    public static void main(String[] args) {
        try {
            SecurityManager securityManager = new SecurityManager() {
                @Override
                public void checkPermission(Permission perm) {
                    if ("accessClassInPackage.sun.reflect".equals(perm.getName())) {
                        // Allow this permission
                        return;
                    }
                    super.checkPermission(perm);
                }
            };
            System.setSecurityManager(securityManager);

            // Attempt to access sun.reflect package to demonstrate the grant
            Class<?> clazz = Class.forName("java.lang.reflect.ReflectionFactory");
            System.out.println("Successfully accessed: " + clazz.getName());
        } catch (AccessControlException e) {
            System.err.println("Permission denied: " + e.getPermission());
        } catch (ClassNotFoundException e) {
            try {
                Class<?> clazz = Class.forName("sun.reflect.ReflectionFactory");
                System.out.println("Successfully accessed: " + clazz.getName());
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}