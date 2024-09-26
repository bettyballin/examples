import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.Vector;
import java.security.Permission;

public class Temp1308 {

    public static void main(String[] args) {
        Temp1308 temp = new Temp1308();
        PermissionCollection pc = temp.newPermissionCollection();
        System.out.println(pc.toString());
    }

    public PermissionCollection newPermissionCollection() {
        return new CustomPermissionCollection();
    }

    class CustomPermissionCollection extends PermissionCollection {
        private Vector<Permission> permissions = new Vector<>();

        @Override
        public void add(Permission permission) {
            permissions.add(permission);
        }

        @Override
        public boolean implies(Permission permission) {
            for (Permission p : permissions) {
                if (p.implies(permission)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public Enumeration<Permission> elements() {
            return permissions.elements();
        }

        @Override
        public boolean isReadOnly() {
            return false;
        }
    }
}