import java.security.Permission;

public class Main72 {

    private static final Permission EXIT_VM_PERM = new RuntimePermission("exitVM.*");

    public static void main(String... args) {
        System.setSecurityManager(new SecurityManager() {
            public void checkPermission(Permission perm) {
                if (perm instanceof RuntimePermission && "exitVM".equals(perm.getName())) {
                    throw new SecurityException("Exiting VM is not allowed");
                }
            }
        });
        try {
            Runtime.getRuntime().exit(0);
        } catch (SecurityException se) {
            handleUnauthorizedVmExitAttempt();
        }
    }

    private static void handleUnauthorizedVmExitAttempt() {
        System.out.println("Exiting VM is not allowed");
    }

}