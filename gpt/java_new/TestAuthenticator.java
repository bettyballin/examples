import org.pac4j.core.context.WebContext;
import org.pac4j.core.credentials.Credentials;
import org.pac4j.core.credentials.TokenCredentials;
import org.pac4j.core.credentials.authenticator.Authenticator;
import org.pac4j.core.exception.CredentialsException;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.store.SessionStore;

public class TestAuthenticator implements Authenticator {

    @Override
    public void validate(Credentials credentials, WebContext context, SessionStore sessionStore) throws CredentialsException {
        if (!(credentials instanceof TokenCredentials)) {
            throw new CredentialsException("Invalid credentials");
        }
        // Implement your authentication logic here
    }
}