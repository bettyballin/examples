import java.io.FilePermission;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.Policy;
import java.security.CodeSource;
import java.net.URL;

public class Temp72 {
    public static void main(String[] args) {
        try {
            URL url = new URL("file:/path/to/students/");
            CodeSource codeSource = new CodeSource(url, (java.security.cert.Certificate[]) null);
            PermissionCollection permissions = new Permissions();
            permissions.add(new FilePermission("/students/*", "read"));
            Policy.setPolicy(new Policy() {
                @Override
                public PermissionCollection getPermissions(CodeSource codesource) {
                    if (codesource.getLocation().equals(url)) {
                        return permissions;
                    } else {
                        return new Permissions();
                    }
                }

                @Override
                public void refresh() {
                }
            });
            System.setSecurityManager(new SecurityManager());

            // Your code here that requires the permissions set above

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}