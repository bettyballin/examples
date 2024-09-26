import java.security.Permission;

public class PreventSystemExitSecurityManager extends SecurityManager {
    private final SecurityManager originalSecurityManager;

    public PreventSystemExitSecurityManager(SecurityManager original) {
        this.originalSecurityManager = original;
    }

    @Override
    public void checkPermission(Permission perm) {
        if (originalSecurityManager != null) {
            originalSecurityManager.checkPermission(perm);
        }
    }

    @Override
    public void checkPermission(Permission perm, Object context) {
        if (originalSecurityManager != null) {
            originalSecurityManager.checkPermission(perm, context);
        }
    }

    @Override
    public void checkExit(int status) {
        throw new SecurityException("System.exit() is not allowed");
    }
}