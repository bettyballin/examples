import java.security.AccessController;
import java.security.PrivilegedAction;

public class Temp698 {
    public static void main(String[] args) {
        AccessController.doPrivileged(new PrivilegedAction<Object>() {
            public Object run() {
                // perform the security-sensitive operation here
                System.out.println("Security-sensitive operation performed.");
                return null;
            }
        });
    }
}