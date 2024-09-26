import java.io.FilePermission;
import java.net.SocketPermission;
import java.security.Permission;

public class CustomSecurityManager1 {
    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
                if ("read".equals(perm.getActions()) || "write".equals(perm.getActions())) {
                    if (perm instanceof FilePermission) {
                        throw new SecurityException(perm.getActions() + " operations are not allowed");
                    }
                }
                if ("connect".equals(perm.getActions())) {
                    if (perm instanceof SocketPermission) {
                        throw new SecurityException("Connect operations are not allowed");
                    }
                }
            }
        });
    }
}