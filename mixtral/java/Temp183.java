import groovy.lang.GroovyShell;
import java.security.Permission;

public class Temp183 {

    public static void main(String[] args) {
        GroovyShell shell = new GroovyShell();
        shell.setSecurityManager(new MyCustomSecurityManager());

        // Run the script
        Object result = shell.evaluate("your_script");
        System.out.println(result);
    }

    static class MyCustomSecurityManager extends SecurityManager {
        @Override
        public void checkPermission(Permission perm) {
            // Custom security checks can be added here
        }

        @Override
        public void checkPermission(Permission perm, Object context) {
            // Custom security checks can be added here
        }
    }
}