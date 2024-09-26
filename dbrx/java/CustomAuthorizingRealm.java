import org.apache.shiro.authc.*;
import org.apache.shiro.authz.*;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomAuthorizingRealm extends AuthorizingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (!(authenticationToken instanceof CustomAuthenticationToken)) { 
            throw new UnsupportedTokenException("Unsupported Token Type");
        }
        
        String username = ((CustomAuthenticationToken) authenticationToken).getUsername();
        Object credentials = authenticationToken.getCredentials();
        
        return new SimpleAuthenticationInfo(username, credentials, getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }
    
    public static class CustomAuthenticationToken implements AuthenticationToken {
        private String username;
        private char[] password;

        public CustomAuthenticationToken(String username, char[] password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        @Override
        public Object getPrincipal() {
            return username;
        }

        @Override
        public Object getCredentials() {
            return password;
        }
    }
}