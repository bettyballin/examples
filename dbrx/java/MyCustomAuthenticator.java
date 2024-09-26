import org.apereo.cas.authentication.credential.UsernamePasswordCredential;
import org.apereo.cas.authentication.handler.HandlerResult;
import org.apereo.cas.authentication.principal.PrincipalFactory;
import org.apereo.cas.services.ServicesManager;
import org.apereo.cas.authentication.handler.support.AbstractJdbcUsernamePasswordAuthenticationHandler;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.GeneralSecurityException;
import javax.security.auth.login.PreventedException;

public class MyCustomAuthenticator extends AbstractJdbcUsernamePasswordAuthenticationHandler {
    private String department;

    public MyCustomAuthenticator(String name, ServicesManager servicesManager, PrincipalFactory principalFactory, Integer order) {
        super(name, servicesManager, principalFactory, order);
    }

    @Override
    protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential credential, String originalPassword) throws GeneralSecurityException, PreventedException {
        this.department = credential.getParameter("department");
        // Add your custom authentication logic here
        return createHandlerResult(credential, this.principalFactory.createPrincipal(credential.getUsername()), null);
    }
}