import java.security.Permission;

public class SystemExitControl1 {
    private static class ExitTrappedException extends SecurityException {}

    private static void forbidSystemExitCall() {
        final SecurityManager securityManager = new SecurityManager() {
            public void checkPermission(Permission permission) {
                if (permission.getName().startsWith("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }

    private static void enableSystemExitCall() {
        System.setSecurityManager(null);
    }

    public static void main(String[] args) {
        try {
            forbidSystemExitCall();
            System.exit(0);
        } catch (ExitTrappedException e) {
            System.out.println("System exit was attempted and caught.");
        } finally {
            enableSystemExitCall();
        }
    }
}