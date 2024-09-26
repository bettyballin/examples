public class MySecurityManager extends SecurityManager {
    @Override
    public void checkPermission(Permission perm) {
        // No action taken, overriding to change behavior.
    }
}