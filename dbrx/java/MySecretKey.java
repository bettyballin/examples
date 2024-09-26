import java.lang.reflect.Field;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class MySecretKey {
    private String key = "2sfdsdf7787fgrtdfg#$%@cj5";

    public void doSomethingSecurely() throws AccessControlException {
        // Perform some secure operation here.
        System.out.println("Doing something securely...");

        try {
            Field field1 = this.getClass().getDeclaredField("key");
            field1.setAccessible(true);
            String keyVal = (String) field1.get(this);

            if (!AccessController.doPrivileged((PrivilegedAction<Boolean>) () -> {
                // Perform privileged action here
                return true;
            })) {
                throw new AccessControlException("Unauthorized access via reflection.");
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            // Handle exceptions here.
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MySecretKey mySecretKey = new MySecretKey();
        try {
            mySecretKey.doSomethingSecurely();
        } catch (AccessControlException e) {
            e.printStackTrace();
        }
    }
}