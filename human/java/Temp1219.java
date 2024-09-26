import java.security.AccessController;
import java.security.PrivilegedAction;

public class Temp1219 {
    public static void main(String[] args) {
        AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
            System.setProperty("java.security.policy", "file:path/to/trusted/application/jars");
            System.setSecurityManager(new SecurityManager());
            return null;
        });

        // Your application code here
        System.out.println("Security policy set successfully.");
    }
}