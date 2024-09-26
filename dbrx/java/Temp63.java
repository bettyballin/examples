import java.security.Permission;
import java.security.AccessControlContext;

public class Main {

    public static void main(String[] args) {
        System.setSecurityManager(new MySecurityManager());
    }

    static class MySecurityManager extends SecurityManager {
        @Override
        public void checkPermission(Permission perm) {
            // Custom security checks can be added here
        }

        @Override
        public void checkPermission(Permission perm, Object context) {
            if (!(context instanceof AccessControlContext)) {
                throw new SecurityException("Context is not an instance of AccessControlContext");
            }
            // Custom security checks can be added here
        }
    }
}