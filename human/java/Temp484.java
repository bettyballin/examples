import java.io.FilePermission;
import java.security.Permission;

public class Temp484 {
    public static void main(String[] args) {
        System.setProperty("java.security.policy", "security.policy");
        System.setSecurityManager(new SecurityManager());

        // Your code logic here
        System.out.println("Security manager is set.");
    }
}

// Example of a security policy file content (save as security.policy in the same directory):
// grant {
//     permission java.io.FilePermission "<<ALL FILES>>", "read,write";
//     permission java.lang.RuntimePermission "setSecurityManager";
// };