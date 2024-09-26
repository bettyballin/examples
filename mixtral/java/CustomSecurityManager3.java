public class CustomSecurityManager extends java.lang.SecurityManager {
    @Override
    public void checkConnect(String host, int port) {
        if (!host.endsWith(".salesforce.com"))
            throw new SecurityException("Access denied to " + host);

        // Call the superclass' method for further checks
        super.checkConnect(host, port);
    }

    public static void main(String[] args) {
        CustomSecurityManager customSecurityManager = new CustomSecurityManager();
        System.setSecurityManager(customSecurityManager);

        try {
            customSecurityManager.checkConnect("example.salesforce.com", 80);
            System.out.println("Connection allowed to example.salesforce.com");

            customSecurityManager.checkConnect("example.com", 80);
            System.out.println("Connection allowed to example.com");
        } catch (SecurityException se) {
            System.out.println(se.getMessage());
        }
    }
}