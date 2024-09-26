import java.io.FilePermission;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.Policy;

public class Temp389 {
    public static void main(String[] args) {
        System.setProperty("java.security.policy", "conf.txt");

        // Create a security manager and set it
        SecurityManager securityManager = new SecurityManager();
        System.setSecurityManager(securityManager);

        // Create and set a default policy
        Policy.setPolicy(new Policy() {
            @Override
            public PermissionCollection getPermissions(java.security.CodeSource codesource) {
                Permissions permissions = new Permissions();
                permissions.add(new FilePermission("<<ALL FILES>>", "read,write"));
                return permissions;
            }
        });

        // Your code logic
        System.out.println("Security policy set successfully.");
    }
}


Additionally, you would need to create a `conf.txt` file containing the security policy configuration. Here's an example content for `conf.txt`:


grant {
    permission java.io.FilePermission "<<ALL FILES>>", "read,write";
};