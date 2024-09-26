import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomLoginModule implements LoginModule {
    private Subject subject;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        this.subject = subject;

        // Initialization code here...
    }

    @Override
    public boolean login() throws LoginException {
        /*
         * Here you can authenticate the user against LDAP and get their roles
         */

        return true;
    }

    @Override
    public boolean commit() throws LoginException {
        // Customize your database query here

        Set<String> customRoles = new HashSet<>();

        /*
         * Here you can add the roles to subject
         */

        this.subject.getPrincipals().addAll(customRoles);

        return true;
    }

    @Override
    public boolean abort() throws LoginException {
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        subject.getPrincipals().clear();
        return true;
    }
}