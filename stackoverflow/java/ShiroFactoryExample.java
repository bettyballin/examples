import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;

public class ShiroFactoryExample {
    public static void main(String[] args) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        
        // Set the SecurityManager for the entire application to use
        org.apache.shiro.SecurityUtils.setSecurityManager(securityManager);
    }
}