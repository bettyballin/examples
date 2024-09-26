import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

public class CustomSecurityManager extends SecurityManager {
    private List<Class<?>> allowedClasses = new ArrayList<>();

    public CustomSecurityManager() {
        super();
        // Add your custom security manager class to the list of allowed classes
        allowedClasses.add(CustomSecurityManager.class);
    }

    @Override
    public void checkPermission(Permission perm) {
        Class<?>[] context = getClassContext();
        if (context != null && context.length > 2) {
            Class<?> caller = context[2]; // index might need adjustment based on the call stack
            if (isAllowedClass(caller)) {
                // Grant permission
                return;
            }

            String packageName = caller.getPackage().getName();
            if (!isAllowedPackage(packageName)) {
                throw new SecurityException("Permission denied for " + caller);
            }
        }
    }

    private boolean isAllowedClass(Class<?> clazz) {
        return allowedClasses.contains(clazz);
    }

    private boolean isAllowedPackage(String packageName) {
        // Implement your logic to determine allowed packages
        return true; // Placeholder, allow all packages
    }

    public static void main(String[] args) {
        CustomSecurityManager customSecurityManager = new CustomSecurityManager();
        System.setSecurityManager(customSecurityManager);

        // Test the CustomSecurityManager
        try {
            System.getProperty("user.home");
            System.out.println("Permission granted.");
        } catch (SecurityException e) {
            System.out.println("Permission denied.");
        }
    }
}