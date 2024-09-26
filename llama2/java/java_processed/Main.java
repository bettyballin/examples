import java.lang.SecurityException;
import java.lang.SecurityManager;

class CustomSecurityManager extends SecurityManager {
    @Override
    public void checkExit(int status) {
        throw new SecurityException("System.exit is not allowed");
    }
}

public class Main {
    public static void main(String[] args) {
        // Set the custom security manager
        System.setSecurityManager(new CustomSecurityManager());
        
        // Example usage
        try {
            System.exit(0);
        } catch (SecurityException e) {
            System.out.println("System.exit is not allowed");
        }
    }
}