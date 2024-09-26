import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import java.util.Arrays;

public class Temp1034 {
    public static void main(String[] args) {
        Temp1034 temp = new Temp1034();
        DefaultWebSecurityManager manager = temp.securityManager();
        System.out.println("Security Manager initialized: " + (manager != null));
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();

        // Set your custom realm
        CustomRealm myRealm = new CustomRealm();

        manager.setRealms(Arrays.asList(myRealm));

        return manager;
    }

    // Dummy CustomRealm class for demonstration purposes
    static class CustomRealm implements Realm {
        @Override
        public String getName() {
            return "customRealm";
        }

        @Override
        public boolean supports(org.apache.shiro.authc.AuthenticationToken token) {
            return false;
        }

        @Override
        public org.apache.shiro.authc.AuthenticationInfo getAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken token) throws org.apache.shiro.authc.AuthenticationException {
            return null;
        }
    }
}