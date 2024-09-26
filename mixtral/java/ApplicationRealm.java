import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationRealm extends AuthorizingRealm {

    private final IAuthRepository authRepo;

    // Constructor
    public ApplicationRealm(IAuthRepository authRepo) {
        this.authRepo = authRepo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // Implement your authorization logic here
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        // Implement your authentication logic here
        // Example:
        if (authRepo.authenticate(username, password)) {
            return new SimpleAuthenticationInfo(username, password, getName());
        } else {
            throw new AuthenticationException("Invalid username or password");
        }
    }
}

interface IAuthRepository {
    boolean authenticate(String username, String password);
}