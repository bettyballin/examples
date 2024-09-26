import java.security.Permission;
import java.security.SecurityManager;

public class PermissionRequest {
    public static void main(String[] args) {
        // Create a custom permission
        Permission perm = new Permission("MyCustomPermission") {
            @Override
            public boolean implies(Permission permission) {
                return false;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public String getActions() {
                return null;
            }

            @Override
            public String getName() {
                return "MyCustomPermission";
            }

            @Override
            public Permission newPermissionCollection() {
                return null;
            }
        };

        // Set a dummy security manager to avoid NullPointerException
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
                // Allow the permission for demonstration purposes
                return;
            }
        });

        // Request the permission from the user
        SecurityManager securityManager = System.getSecurityManager();
        securityManager.checkPermission(perm);

        // If the user grants the permission you can continue with your application
        System.out.println("Permission granted");
    }
}