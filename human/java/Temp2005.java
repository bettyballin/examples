import java.security.AccessController;
import java.security.PrivilegedAction;

public class Temp2005 {
    public static void main(String[] args) {
        
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                System.setProperty("java.security.policy", "file:./MyApplication.jar");
                System.setSecurityManager(new SecurityManager());
                return null;
            }
        });

        // Your application logic here
        System.out.println("Security policy applied.");
    }
}