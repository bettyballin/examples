import java.security.Permission;

public class Temp1423 {
    public static void main(String[] args) {

        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {}

            @Override
            public void checkPermission(Permission perm, Object context) {}

            // Your custom implementation of the System.exit behavior
            @Override
            public void checkExit(int status) {
                Thread.dumpStack();
                super.checkExit(status);
            }
        });

        // Triggering the custom System.exit behavior for testing
        System.exit(0);
    }
}