import java.security.Permission;

public class Temp2004 {

    public static void main(String[] args) {
        SecurityManager sm = new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
                // Allow all permissions
            }
        };
        System.setSecurityManager(sm);

        // Your code that requires all permissions goes here
        System.out.println("All permissions granted.");
    }
}