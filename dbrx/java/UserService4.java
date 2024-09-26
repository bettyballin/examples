import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;

@Stateless
public class UserService {

    @PersistenceContext(unitName = "myPU")
    private EntityManager em;

    public void addUser(User user) {
        // ...
        em.persist(user);
    }

    public User findUser(String username, String password) {
        // ...
        return em.find(User.class, username);
    }
}

@Stateless
public class SecurityService {

    @Resource
    private SessionContext sessionCtx;

    public void login(String username, char[] password) throws LoginException {
        CallbackHandler handler = new UsernamePasswordCallbackHandler(username, password);
        LoginContext lc = new LoginContext("myJAASConfig", handler);
        lc.login();
        Subject subject = lc.getSubject();
        sessionCtx.setCallerPrincipal(subject.getPrincipals().iterator().next());
    }
}

public class UsernamePasswordCallbackHandler implements CallbackHandler {

    private String username;
    private char[] password;

    public UsernamePasswordCallbackHandler(String username, char[] password) {
        this.username = username;
        this.password = Arrays.copyOf(password, password.length);
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof NameCallback) {
                ((NameCallback) callback).setName(username);
            } else if (callback instanceof PasswordCallback) {
                ((PasswordCallback) callback).setPassword(password);
            }
        }
    }
}

class User {
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}