import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;

public class Temp430 {
    public static void main(String[] args) {
        // Replace these with actual username and password
        String username = "yourUsername";
        String password = "yourPassword";

        // Create a security manager
        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        // Create a realm
        SimpleAccountRealm realm = new SimpleAccountRealm();
        realm.addAccount(username, password);

        // Set the realm for the security manager
        securityManager.setRealm(realm);

        // Set the security manager
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            System.out.println("Login successful!");
        } catch (AuthenticationException e) {
            System.out.println("Login failed: " + e.getMessage());
            // handle exception and redirect to login page again with error message
        }
    }
}