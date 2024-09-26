import java.io.FilePermission;
import java.security.AccessController;
import java.security.PermissionCollection;
import java.security.Policy;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;

public class Temp1203 {
    public static void main(String[] args) {
        // Create a file permission
        FilePermission filePermission = new FilePermission("<<ALL FILES>>", "read");

        // Add the permission to a permission collection
        PermissionCollection permissionCollection = filePermission.newPermissionCollection();
        permissionCollection.add(filePermission);

        // Set a custom security policy
        Policy.setPolicy(new Policy() {
            @Override
            public PermissionCollection getPermissions(ProtectionDomain domain) {
                return permissionCollection;
            }
        });

        // Refresh the policy to apply changes
        Policy.getPolicy().refresh();

        // Execute an action with the applied permissions
        AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
            // Your code that requires the file permission goes here
            System.out.println("File read permission granted.");
            return null;
        });
    }
}