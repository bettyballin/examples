import java.security.Permission;

public class CustomSecurityManager2 extends SecurityManager {
    @Override
    public void checkPermission(Permission perm) {
        // Allowing all checkPermission calls to proceed
    }

    @Override
    public void checkPermission(Permission perm, Object context) {
        // Allowing all checkPermission calls with context to proceed
    }
}

public class Main {
    public static void main(String[] args) {
        System.setSecurityManager(new CustomSecurityManager2());
        // Rest of the code
    }
}