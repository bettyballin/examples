import java.security.Permission;

class MySecurityManager extends SecurityManager {
    @Override
    public void checkPermission(Permission perm) {
        // Allow all actions
    }

    @Override
    public void checkPermission(Permission perm, Object context) {
        // Allow all actions
    }
}

public class Temp464 {
    public static void main(String[] args) {
        SecurityManager sm = new MySecurityManager();
        System.setSecurityManager(sm);
        System.out.println("Custom Security Manager is set.");
    }
}