import java.security.Permission;

public class Temp555 {
    public static void main(String[] args) {
        Permission readPermission = new RuntimePermission("readFileDescriptor");
        Permission writePermission = new RuntimePermission("writeFileDescriptor");

        SecurityManager securityManager = System.getSecurityManager();
        
        if (securityManager != null) {
            try {
                securityManager.checkPermission(readPermission);
                System.out.println("Read file descriptor permission granted.");
            } catch (SecurityException se) {
                System.out.println("Read file descriptor permission denied.");
            }

            try {
                securityManager.checkPermission(writePermission);
                System.out.println("Write file descriptor permission granted.");
            } catch (SecurityException se) {
                System.out.println("Write file descriptor permission denied.");
            }
        } else {
            System.out.println("No security manager installed.");
        }
    }
}