import java.awt.Desktop;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.security.AllPermission;

public class ElevatingSecurityManager extends SecurityManager {
    private static final Permission ALL_PERMISSIONS = new AllPermission();

    @Override
    public void checkPermission(final Permission permission) {
        if (permission instanceof AllPermission) {
            // Request temporary permission escalation
            AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
                final AccessControlContext context = AccessController.getContext();
                context.checkPermission(ALL_PERMISSIONS);
                return null;
            });
        } else {
            super.checkPermission(permission);
        }
    }

    public static void main(String[] args) {
        System.setSecurityManager(new ElevatingSecurityManager());
        // Your code to test the security manager
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(new java.io.File("."));
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}