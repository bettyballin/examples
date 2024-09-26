import groovy.lang.GroovyShell;

class DisallowAllSecurityManager extends SecurityManager {
    @Override
    public void checkPermission(java.security.Permission perm) {
        // Disallow all permissions
        throw new SecurityException("All permissions are disallowed.");
    }
}

public class Temp33 {
    public static void main(String[] args) {
        SecurityManager securityManager = System.getSecurityManager();
        try {
            System.setSecurityManager(new DisallowAllSecurityManager());
            GroovyShell groovyShell = new GroovyShell();
            String expression = "return 42"; // Example expression
            Object result = groovyShell.evaluate(expression);
            System.out.println("Result: " + result);
        } catch (SecurityException se) {
            System.err.println("SecurityException caught: " + se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.setSecurityManager(securityManager);
        }
    }
}