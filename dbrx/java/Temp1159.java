import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

public class Temp1159 {
    public static void main(String[] args) {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        subject.login(new org.apache.shiro.authc.UsernamePasswordToken("username", "password"));
        Temp1159 instance = new Temp1159();
        System.out.println(instance.myResourceMethod());
    }

    @RequiresAuthentication 
    public String myResourceMethod() {
        // Implement the method logic here
        return "Resource accessed!";
    }
}