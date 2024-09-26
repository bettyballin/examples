import java.security.Policy;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.CodeSource;
import java.security.cert.Certificate;
import java.net.SocketPermission;
import java.net.URL;
import java.security.AllPermission;

public class Temp116 {
    public static void main(String[] args) {
        try {
            // Define permissions
            Permissions perms = new Permissions();
            perms.add(new SocketPermission("localhost:1024-", "connect, resolve"));

            // Assuming no certificates
            CodeSource cs = new CodeSource(new URL("file:///"), (Certificate[]) null);

            // Create a policy
            Policy policy = new Policy() {
                @Override
                public PermissionCollection getPermissions(CodeSource codesource) {
                    if (codesource.equals(cs)) {
                        return perms;
                    }
                    return new Permissions();
                }
            };

            // Set the policy as the system policy
            Policy.setPolicy(policy);
            System.setSecurityManager(new SecurityManager());

            // Test permission by connecting to a local socket
            java.net.Socket socket = new java.net.Socket("localhost", 8080);
            System.out.println("Connected to localhost:8080");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}