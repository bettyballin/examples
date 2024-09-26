import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessController;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.Policy;
import java.security.PrivilegedAction;
import java.io.FilePermission;
import java.util.Enumeration;

public class CustomClassLoader extends URLClassLoader {
    public CustomClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);

        // Grant read permission to all files
        AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
            Policy policy = Policy.getPolicy();

            if (policy != null && !isAllPermissionGranted()) {
                PermissionCollection perms = new Permissions();

                // Grant read permission to all files
                FilePermission filePerms = new FilePermission("<<ALL FILES>>", "read");

                perms.add(filePerms);

                policy.refresh();
            }

            return null;
        });
    }

    private boolean isAllPermissionGranted() {
        PermissionCollection permColl = Policy.getPolicy().getPermissions(new java.security.AllPermission());

        for (Enumeration<Permission> e = permColl.elements(); e.hasMoreElements();) {
            Permission perm = e.nextElement();
            if (perm instanceof java.security.AllPermission) {
                return true;
            }
        }
        return false;
    }
}