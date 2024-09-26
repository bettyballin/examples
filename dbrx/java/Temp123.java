import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class Temp123 {
    public static void main(String[] args) {
        // Setup Shiro environment
        Realm realm = new IniRealm("classpath:shiro.ini");
        SecurityManager securityManager = new DefaultSecurityManager(realm);
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        // Authenticate the subject
        subject.login(new UsernamePasswordToken("username", "password"));

        String roleName = "admin";
        boolean roleExists = subject.hasRole(roleName);

        System.out.println("Does the role 'admin' exist? " + roleExists);
    }
}