import java.security.Permission;
import java.security.PermissionCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;

public class CustomPermissionCollection extends PermissionCollection {

    private static final long serialVersionUID = 5654758059940546018L;

    Collection<Permission> perms = new ArrayList<>();

    @Override
    public void add(Permission permission) {
        perms.add(permission);
    }

    @Override
    public boolean implies(Permission permission) {
        for (Permission p : perms) {
            if (p.implies(permission))
                return true;
        }
        return false;
    }

    @Override
    public Enumeration<Permission> elements() {
        return Collections.enumeration(perms);
    }

    public static void main(String[] args) {
        CustomPermissionCollection collection = new CustomPermissionCollection();
        Permission p1 = new RuntimePermission("readFile");
        Permission p2 = new RuntimePermission("writeFile");

        collection.add(p1);

        System.out.println("Collection implies readFile: " + collection.implies(p1));
        System.out.println("Collection implies writeFile: " + collection.implies(p2));
    }
}