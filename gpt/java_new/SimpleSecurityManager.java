import java.security.Permission;

public class SimpleSecurityManager extends SecurityManager {

    private static final ThreadLocal<Boolean> checking = new ThreadLocal<>();

    @Override
    public void checkPermission(Permission perm) {
        Boolean flag = checking.get();
        if (Boolean.TRUE.equals(flag)) {
            return;
        }

        try {
            checking.set(Boolean.TRUE);

            // Implement your logic here

        } finally {
            checking.set(Boolean.FALSE);
        }
    }
}