import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecurityManager;

public class SecureAI {
    public static void main(String[] args) throws Exception {

        // Set up a security manager with our customized policy.
        System.setSecurityManager(new SecurityManager());

        try {
            AccessController.doPrivileged((PrivilegedAction<Object>) () -> {
                // Your code here
                return null;
            });

        } catch (AccessControlException e) {
            System.out.println("Reflection is not allowed!");
        }
    }
}