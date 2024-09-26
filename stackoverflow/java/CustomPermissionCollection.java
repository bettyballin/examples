import java.security.Permission;
import java.security.PermissionCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;

public class CustomPermissionCollection extends PermissionCollection {
    private static final long serialVersionUID = 5654758059940546018L;
    private Collection<Permission> perms = new ArrayList<>();

    @Override
    public void add(Permission permission) {
        if (isReadOnly()) {
            throw new SecurityException("attempt to add a Permission to a readonly PermissionCollection");
        }
        perms.add(permission);
    }

    @Override
    public boolean implies(Permission permission) {
        for (Permission p : perms) {
            if (p.implies(permission)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Enumeration<Permission> elements() {
        return Collections.enumeration(perms);
    }
}