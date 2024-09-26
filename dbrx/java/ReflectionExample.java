import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        try {
            // This will throw an exception due to restricted permissions.
            Class<?> clazz = Class.forName("sun.reflect.Reflection");
            System.out.println(clazz.getName());
        } catch (AccessControlException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

        PrivilegedAction<String> action = new PrivilegedAction<String>() {
            @Override
            public String run() {
                String result;
                try {
                    // This will work because it's inside a privileged block.
                    Class<?> clazz = Class.forName("sun.reflect.Reflection");
                    result = clazz.getName();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                return result;
            }
        };

        System.out.println(AccessController.doPrivileged(action));
    }
}