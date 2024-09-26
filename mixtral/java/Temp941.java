import java.security.Permission;

public class Temp941 {
    public static void main(String[] args) {
        System.setSecurityManager(new CustomSecurityManager());
        System.out.println("Custom security manager set.");
    }
}

class CustomSecurityManager extends SecurityManager {
    @Override
    public void checkPermission(Permission perm) {
        // Allow all permissions
    }

    @Override
    public void checkPermission(Permission perm, Object context) {
        // Allow all permissions
    }
}