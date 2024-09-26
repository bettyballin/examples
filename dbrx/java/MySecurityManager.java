import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.security.AccessControlException;

public class MySecurityManager extends SecurityManager {
    @Override
    public void checkMemberAccess(Class<?> clazz, int which) {
        if (which == Member.PUBLIC && !clazz.getName().equals("YourClass")) {
            throw new AccessControlException("Reflection access denied");
        }

        // Check for the specific field.
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            if ("privateFinalFieldName".equals(f.getName())) {  // Replace with your private final field name
                return;
            }
        }

        throw new AccessControlException("Reflection access denied");
    }

    // Override other methods as needed.
}

public class YourClass {
    private final String privateFinalFieldName = "example";

    public static void main(String[] args) {
        System.setSecurityManager(new MySecurityManager());

        // Your code to test the security manager
        try {
            Field field = YourClass.class.getDeclaredField("privateFinalFieldName");
            System.out.println("Access to field: " + field.getName());
        } catch (Exception e) {
            System.out.println("Access denied: " + e.getMessage());
        }
    }
}