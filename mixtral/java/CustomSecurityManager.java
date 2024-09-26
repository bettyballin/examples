public class Main {
    public static void main(String[] args) {
        CustomSecurityManager customSecurityManager = new CustomSecurityManager();
        System.setSecurityManager(customSecurityManager);

        System.out.println("Custom Security Manager is set.");
        
        try {
            System.exit(1);
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

        System.exit(0);
    }
}

class CustomSecurityManager extends SecurityManager {
    @Override
    public void checkExit(int status) {
        if (status != 0) {
            throw new SecurityException("Unauthorized program termination.");
        }
        // Allow normal completion
    }
}