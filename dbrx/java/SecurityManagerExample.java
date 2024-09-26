import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecurityManager;

public class SecurityManagerExample {
    public static void main(String[] args) throws Exception {
        // Set the security manager.
        System.setSecurityManager(new MySecurityManager());

        try {
            AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
                System.exit(0);
                return null;
            });

            throw new RuntimeException("System.exit should have thrown an exception");
        } catch (AccessControlException e) {
            // This is expected.
            System.out.println("Caught expected AccessControlException: " + e.getMessage());
        }
    }

    static class MySecurityManager extends SecurityManager {

        @Override
        public void checkExit(int status) {
            if (!isCoreApplication(Thread.currentThread().getStackTrace())) {  
                throw new AccessControlException("Access denied \"exitVM." + status + "\"");
            }
            super.checkExit(status);
        }
        
        private boolean isCoreApplication(StackTraceElement[] stackTrace) {
            for(StackTraceElement element : stackTrace) {
                if(element.getClassName().equals(SecurityManagerExample.class.getName())) {
                    return true;
                }
            }
            return false;
        }
    }
}