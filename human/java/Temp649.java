import java.security.AccessController;
import java.security.PermissionCollection;
import java.security.Policy;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.security.Permissions;
import java.io.FilePermission;
import java.net.URL;

public class Temp649 {
    public static void main(String[] args) {
        // Create a custom policy
        Policy customPolicy = new Policy() {
            public PermissionCollection getPermissions(CodeSource codeSource) {
                Permissions permissions = new Permissions();
                try {
                    URL location = codeSource.getLocation();
                    String path = location.toString();
                    if (path.startsWith("file:/some/root/path/sandbox/")) {
                        permissions.add(new FilePermission("*", "read"));
                        permissions.add(new FilePermission("/tmp/*", "read,write"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return permissions;
            }

            public void refresh() {
            }
        };

        // Set the custom policy
        Policy.setPolicy(customPolicy);
        System.setSecurityManager(new SecurityManager());

        // Test the permissions
        AccessController.doPrivileged((java.security.PrivilegedAction<Void>) () -> {
            try {
                // Attempt to read a file (should be allowed if it matches the policy)
                java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("/some/root/path/sandbox/test.txt"));
                System.out.println("Read permission granted.");

                // Attempt to write a file (should be allowed if it matches the policy)
                java.nio.file.Files.write(java.nio.file.Paths.get("/tmp/test.txt"), "Hello, World!".getBytes());
                System.out.println("Write permission granted.");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        });
    }
}