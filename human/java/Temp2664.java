import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;

public class Temp2664 {
    public static void main(String[] args) {
        // Assuming DemoToken and profile are defined somewhere in your code
        DemoToken profile = new DemoToken(/* parameters if any */);

        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(profile);
            System.out.println("Login successful!");
        } catch (AuthenticationException ae) {
            System.out.println("Login failed: " + ae.getMessage());
        }
    }
}

// Assuming a definition of DemoToken for the example
class DemoToken extends org.apache.shiro.authc.UsernamePasswordToken {
    public DemoToken() {
        super("username", "password"); // Replace with actual logic
    }
}