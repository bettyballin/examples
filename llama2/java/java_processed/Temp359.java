import java.security.Permission;

public class Temp359 {
    public static void main(String[] args) {
        SecurityManager security = new RestrictedSecurityManager();
        System.setSecurityManager(security);
    }
}

class RestrictedSecurityManager extends SecurityManager {
    @Override
    public void checkPermission(Permission perm) {
        // No permissions granted
    }
}