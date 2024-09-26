import java.io.IOException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.apache.wss4j.common.ext.WSPasswordCallback;

public class CustomPasswordCallback implements CallbackHandler {
    private final UserDetailsService userDetailsService;

    public CustomPasswordCallback(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof WSPasswordCallback) {
                WSPasswordCallback passwordCallback = (WSPasswordCallback) callback;
                String username = passwordCallback.getIdentifier();
                try {
                    String password = userDetailsService.loadUserByUsername(username).getPassword();
                    passwordCallback.setPassword(password);
                } catch (UsernameNotFoundException e) {
                    throw new IOException("User not found: " + username, e);
                }
            } else {
                throw new UnsupportedCallbackException(callback, "Unsupported callback type");
            }
        }
    }
}