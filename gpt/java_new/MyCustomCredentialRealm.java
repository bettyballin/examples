import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

public class MyCustomCredentialRealm extends AuthenticatingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // Assuming token is of type UsernamePasswordToken, perform casting and use it for authentication
        // Here you should implement the logic to verify the username and password against your credentials' source.
        // The following is just a placeholder example where "username" and "password" are the expected credentials.

        // Example credential verification
        String expectedUsername = "username";
        String expectedPassword = "password";

        if (expectedUsername.equals(token.getPrincipal()) && expectedPassword.equals(new String((char[]) token.getCredentials()))) {
            PrincipalCollection principals = new SimplePrincipalCollection(expectedUsername, getName());
            return new SimpleAuthenticationInfo(principals, expectedPassword);
        } else {
            throw new AuthenticationException("Invalid username or password");
        }
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof MyCustomCredential;
    }
}

// Custom credential class
class MyCustomCredential extends UsernamePasswordCredential {
    private String department;

    public MyCustomCredential() {
    }

    public MyCustomCredential(String username, String password, String department) {
        super(username, password);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

// Base credential class to extend from
class UsernamePasswordCredential implements AuthenticationToken {
    private String username;
    private String password;

    public UsernamePasswordCredential() {
    }

    public UsernamePasswordCredential(String username, String password) {
        this.username = username;
        this.password = password;
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