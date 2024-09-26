import java.security.*;
import java.security.cert.Certificate;
import java.security.CodeSource;
import java.util.Enumeration;

public class ShowPolicy {
    public static void main(String[] args) throws Exception {
        Policy policy = Policy.getPolicy();
        PermissionCollection pc = new Permissions();

        CodeSource codeSource = new CodeSource(null, (Certificate[]) null);

        PermissionCollection permissions = policy.getPermissions(codeSource);

        for (Enumeration<Permission> e = permissions.elements(); e.hasMoreElements(); ) {
            Permission p = e.nextElement();
            if (!pc.implies(p)) {
                System.out.println("Granted: " + p);
            }
        }
    }
}