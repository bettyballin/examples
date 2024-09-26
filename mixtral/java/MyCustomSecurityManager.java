import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.security.AccessControlException;
import java.security.Permission;
import java.security.ReflectPermission;

public class MyCustomSecurityManager extends SecurityManager {

    @Override
    public void checkPermission(Permission perm) {}

    // Override this method to restrict access only to a particular field
    private boolean isFieldAccessAllowed(Class<?> clazz, String name) {
        for (Field f : clazz.getDeclaredFields()) {
            if (!f.isSynthetic() && !Modifier.isPrivate(f.getModifiers())) {
                if (f.getName().equals(name)) {
                    // Allow access to the specific field
                    return true;
                }
            }
        }
        throw new SecurityException("Access denied");
    }

    @Override
    public void checkMemberAccess(Class<?> clazz, int which) throws AccessControlException {
        if (which == Member.PUBLIC) {
            return;
        }

        super.checkPermission(new ReflectPermission("suppressAccessChecks"));

        throw new SecurityException();
    }

    public static void main(String[] args) {
        MyCustomSecurityManager securityManager = new MyCustomSecurityManager();
        System.setSecurityManager(securityManager);

        try {
            securityManager.checkMemberAccess(MyCustomSecurityManager.class, Member.PUBLIC);
            System.out.println("Access granted");
        } catch (SecurityException e) {
            System.out.println("Access denied: " + e.getMessage());
        }
    }
}