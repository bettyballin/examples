public class DebugJavaSecurity {
    public static void main(String[] args) {
        System.setProperty("java.security.debug", "access=domain,access=failure,policy");
        // Your code here. For example:
        try {
            System.out.println("Debugging java.security...");
            // Example code to trigger security check
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                sm.checkRead("testfile.txt");
            } else {
                System.out.println("No SecurityManager installed.");
            }
        } catch (SecurityException se) {
            System.out.println("SecurityException caught: " + se.getMessage());
        }
    }
}