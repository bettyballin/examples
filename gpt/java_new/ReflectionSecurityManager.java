import java.security.Permission;
import java.lang.reflect.ReflectPermission;

public class ReflectionSecurityManager extends SecurityManager {
    
    @Override
    public void checkPermission(Permission perm) {
        // Allow anything if it's not a ReflectPermission
        if (!(perm instanceof ReflectPermission)) {
            return;
        }

        // Check the stack trace to determine the context of the reflection call
        Class<?>[] classContext = getClassContext();
        for (Class<?> c : classContext) {
            // If we find Class.forName in the stack trace, we're done
            if (c.getName().equals("java.lang.Class") && isReflectiveCall(c)) {
                throw new SecurityException("Reflection is not allowed");
            }
        }
    }

    private boolean isReflectiveCall(Class<?> c) {
        // Check for known reflective methods here
        // This is a dummy implementation
        return true;
    }
}