import java.security.Policy;
import java.security.Permission;
import java.security.Policy.Parameters;
import java.security.ProtectionDomain;
import java.security.CodeSource;
import java.io.FilePermission;
import java.net.URL;

public class PolicyExample {
    public static void main(String[] args) throws Exception {
        Policy.setPolicy(new Policy() {
            @Override
            public boolean implies(ProtectionDomain domain, Permission permission) {
                if (permission instanceof FilePermission && permission.getActions().equals("read")) {
                    // Replace with the actual location you wish to check
                    return "/usr/share/java/jsp-api-2.0.jar".equals(permission.getName());
                }
                return super.implies(domain, permission);
            }
        });
        System.setSecurityManager(new SecurityManager());

        // Your application logic here
    }
}