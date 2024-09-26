import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.Permission;

public class CryptoPolicyPatcher {
    public static void removeCryptographyRestrictions() {
        try {
            final Class<?> jceSecurity = Class.forName("javax.crypto.JceSecurity");
            final Class<?> cryptoPermissions = Class.forName("javax.crypto.CryptoPermissions");
            final Class<?> cryptoAllPermission = Class.forName("javax.crypto.CryptoAllPermission");

            final Field isRestrictedField = jceSecurity.getDeclaredField("isRestricted");
            isRestrictedField.setAccessible(true);
            isRestrictedField.setBoolean(null, false);

            final Field defaultPolicyField = jceSecurity.getDeclaredField("defaultPolicy");
            defaultPolicyField.setAccessible(true);
            final Permission defaultPolicy = (Permission) defaultPolicyField.get(null);

            final Field perms = cryptoPermissions.getDeclaredField("perms");
            perms.setAccessible(true);
            ((Map) perms.get(defaultPolicy)).clear();

            final Field instance = cryptoAllPermission.getDeclaredField("INSTANCE");
            instance.setAccessible(true);
            final Permission allPermission = (Permission) instance.get(null);

            final Method add = cryptoPermissions.getDeclaredMethod("add", Permission.class);
            add.setAccessible(true);
            add.invoke(defaultPolicy, allPermission);

        } catch (final Exception e) {
            throw new RuntimeException("Failed to remove cryptography restrictions", e);
        }
    }

    public static void main(String[] args) {
        removeCryptographyRestrictions();
    }
}