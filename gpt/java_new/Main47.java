public class Main47 {
    public static void main(String[] args) {
        // Set the security manager if it is not already set.
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        // Get the current security manager.
        SecurityManager appsm = System.getSecurityManager();

        System.out.println("something");

        try {
            // Check if the security manager allows JVM exit with status 0.
            appsm.checkExit(0);
            // If no exception is thrown, the current thread is allowed to exit the JVM.
        } catch (SecurityException se) {
            // The SecurityException indicates the current thread is not allowed to exit the JVM.
            se.printStackTrace();
        }
    }
}