import javax.crypto.Cipher;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CryptoPolicyOverride {
    public static void main(String[] args) {
        try {
            Field gate = Class.forName("javax.crypto.JceSecurity").getDeclaredField("isRestricted");
            gate.setAccessible(true);
            gate.setBoolean(null, false);

            Field allPerm = Class.forName("javax.crypto.CryptoAllPermission").getDeclaredField("INSTANCE");
            allPerm.setAccessible(true);
            Object accessAllAreasCard = allPerm.get(null);

            Constructor<?> constructor = Class.forName("javax.crypto.CryptoPermissions").getDeclaredConstructor();
            constructor.setAccessible(true);
            Object coll = constructor.newInstance();

            Method addPerm = Class.forName("javax.crypto.CryptoPermissions").getDeclaredMethod("add", java.security.Permission.class);
            addPerm.setAccessible(true);
            addPerm.invoke(coll, accessAllAreasCard);

            Field defaultPolicy = Class.forName("javax.crypto.JceSecurity").getDeclaredField("defaultPolicy");
            defaultPolicy.setAccessible(true);
            defaultPolicy.set(null, coll);

            System.out.println("Successfully modified crypto policy");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}