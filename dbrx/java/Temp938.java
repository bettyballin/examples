import java.security.AccessController;
import java.security.PrivilegedAction;

public class Main {
    public static void main(String[] args) {
        AccessController.doPrivileged(new PrivilegedAction<Object>() {
            public Object run() {
                try {
                    String UNTRUSTED_CLASS = "java.util.ArrayList"; // Replace with the actual class name
                    ClassLoader classLoader = Main.class.getClassLoader(); // Replace with the actual class loader if needed
                    return Class.forName(UNTRUSTED_CLASS, true, classLoader).getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}