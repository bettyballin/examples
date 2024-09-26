import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class JceSecurityManager {
    static {
        AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
            try {
                Field field = Class.forName("javax.crypto.JceSecurity").getDeclaredField("isRestricted");
                field.setAccessible(true);

                Field modifiersField = Field.class.getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

                field.set(null, false);
            } catch (Exception e) {
                throw new RuntimeException("Failed to modify JceSecurity.isRestricted field", e);
            }
            return null;
        });
    }

    public static void main(String[] args) {
        // You can now use JCE without restrictions
    }
}