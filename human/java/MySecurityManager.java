import java.security.Permission;

public class Main {
    private static class MySecurityManager extends SecurityManager {
        @Override
        public void checkPermission(Permission perm) {
            return;
        }
    }

    public static void main(String[] args) {
        MySecurityManager mySecurityManager = new MySecurityManager();
        System.setSecurityManager(mySecurityManager);
        System.out.println("Custom Security Manager set.");
    }
}