import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.CodeSource;
import java.security.Policy;
import java.security.ProtectionDomain;
import java.io.FilePermission;
import java.util.PropertyPermission;
import java.net.URL;

public class Temp8 {
    public static void main(String[] args) {
        Policy.setPolicy(new CustomPolicy());
        System.setSecurityManager(new SecurityManager());

        // Application logic here
        System.out.println("Security policy applied successfully!");
    }
}

class CustomPolicy extends Policy {
    @Override
    public PermissionCollection getPermissions(CodeSource codesource) {
        Permissions perms = new Permissions();
        try {
            URL location = codesource.getLocation();
            if (location != null) {
                String path = location.getPath();
                if (path.startsWith("/path/to/app/lib/")) {
                    perms.add(new FilePermission("/path/to/app/-", "read"));
                    perms.add(new FilePermission("/path/to/app/data/-", "read,write,delete"));
                } else if (path.startsWith("/path/to/app/ext/")) {
                    perms.add(new PropertyPermission("java.io.tmpdir", "read"));
                    perms.add(new FilePermission(System.getProperty("java.io.tmpdir") + "/myapp/-", "read,write,delete"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return perms;
    }

    @Override
    public void refresh() {
        // No implementation needed
    }
}