import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RemoveCryptoRestrictions {

    private static final Logger logger = Logger.getLogger(RemoveCryptoRestrictions.class.getName());

    public static void main(String[] args) {
        removeCryptographyRestrictions();
    }

    private static void removeCryptographyRestrictions() {
        if (!isRestrictedCryptography()) {
            return;
        }
        try {
            Field isRestricted;
            try {
                final Class<?> c = Class.forName("javax.crypto.JceSecurity");
                isRestricted = c.getDeclaredField("isRestricted");
            } catch (final ClassNotFoundException e) {
                try {
                    // Java 6 has obfuscated JCE classes
                    final Class<?> c = Class.forName("javax.crypto.SunJCE_b");
                    isRestricted = c.getDeclaredField("g");
                } catch (final ClassNotFoundException e2) {
                    throw e;
                }
            }
            isRestricted.setAccessible(true);
            isRestricted.set(null, false);
        } catch (final Throwable e) {
            logger.log(Level.WARNING, "Failed to remove cryptography restrictions", e);
        }
    }

    private static boolean isRestrictedCryptography() {
        return "Java(TM) SE Runtime Environment".equals(System.getProperty("java.runtime.name"));
    }
}