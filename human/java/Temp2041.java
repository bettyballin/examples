import java.lang.reflect.Field;
import javax.crypto.CryptoAllPermissionCollection;
import javax.crypto.JceSecurity;

public class Temp2041 {
    public static void main(String[] args) {
        try {
            Field isRestrictedField = JceSecurity.class.getDeclaredField("isRestricted");
            isRestrictedField.setAccessible(true);
            isRestrictedField.set(null, false);
            System.out.println("Successfully set javax.crypto.JceSecurity.isRestricted to false");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}