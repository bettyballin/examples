import java.security.Permission;
import java.security.SecurityManager;

public class Temp58 {
    public static void main(String[] args) {
        grantPermissions();
    }

    private static void grantPermissions() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new SocketPermission("10.130.71.156:8000", "connect,accept"));
            sm.checkPermission(new PropertyPermission("user.home", "read"));
        } else {
            System.out.println("No SecurityManager is set.");
        }
    }

    static class SocketPermission extends Permission {
        private String actions;

        public SocketPermission(String name, String actions) {
            super(name);
            this.actions = actions;
        }

        @Override
        public boolean implies(Permission permission) {
            return false;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public String getActions() {
            return actions;
        }
    }

    static class PropertyPermission extends Permission {
        private String actions;

        public PropertyPermission(String name, String actions) {
            super(name);
            this.actions = actions;
        }

        @Override
        public boolean implies(Permission permission) {
            return false;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public String getActions() {
            return actions;
        }
    }
}