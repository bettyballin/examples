import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.Configuration;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.util.Map;
import java.util.HashMap;

public class CustomLoginContext extends LoginContext {
    private Map<String, Object> sharedState;

    public CustomLoginContext(String name, Subject subject, CallbackHandler callbackHandler, Configuration config, Map<String, Object> sharedState) throws LoginException {
        super(name, subject, callbackHandler, config);
        this.sharedState = sharedState == null ? new HashMap<>() : new HashMap<>(sharedState);
    }
}