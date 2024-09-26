import java.security.AccessController;
import java.security.PrivilegedAction;

public class Temp349 {
    public static void main(String[] args) {
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                // Permissions are granted in a policy file, not in code
                System.out.println("Runtime permissions granted.");
                return null;
            }
        });
    }
}