import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setSecurityManager(new MySecurityManager());

        Class<?> clazz = YourClass.class;
        Field field = clazz.getDeclaredField("yourPrivateFinalField");
        // Use doPrivileged to bypass SecurityManager
        java.security.AccessController.doPrivileged(new java.security.PrivilegedExceptionAction<Void>() {
            public Void run() throws Exception {
                field.setAccessible(true);
                return null;
            }
        });
    }
}

class MySecurityManager extends SecurityManager {
    @Override
    public void checkPermission(java.security.Permission perm) {
        // Allow everything except setting accessible to true
        if ("suppressAccessChecks".equals(perm.getName())) {
            throw new SecurityException("Setting accessible is not allowed");
        }
    }
}

class YourClass {
    private final String yourPrivateFinalField = "secret";
}