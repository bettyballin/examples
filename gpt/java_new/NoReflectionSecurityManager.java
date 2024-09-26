import java.lang.reflect.ReflectPermission;
import java.security.Permission;

public class NoReflectionSecurityManager extends SecurityManager {
    @Override
    public void checkPermission(Permission perm) {
        if (perm instanceof ReflectPermission) {
            throw new SecurityException("Reflection is not allowed");
        }
        super.checkPermission(perm);
    }
    
    public static void main(String[] args) {
        System.setSecurityManager(new NoReflectionSecurityManager());
    }
}