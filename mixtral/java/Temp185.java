import java.security.Policy;
import groovy.lang.GroovyShell;
import groovy.lang.GroovySystem;
import org.codehaus.groovy.control.CompilerConfiguration;

public class Temp185 {
    public static void main(String[] args) {
        Policy.setPolicy(new PolicyFile("my_policy.policy"));
        System.setSecurityManager(new MyCustomSecurityManager());

        CompilerConfiguration config = new CompilerConfiguration();
        GroovyShell shell = new GroovyShell(config);

        // Run the script
        Object result = shell.evaluate("your_script");

        System.out.println("Script result: " + result);
    }
}

class MyCustomSecurityManager extends SecurityManager {
    // Custom security manager implementation
}