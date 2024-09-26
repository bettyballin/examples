import org.apache.ws.security.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

public class ClientPasswordCallback implements CallbackHandler {
    private String username;
    private String password;

    public ClientPasswordCallback(String userName, String passWord) {
        this.username = userName;
        this.password = passWord;
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];

        if ("my-username".equals(pc.getIdentifier())) {
            // set the password for our message
            pc.setPassword("my-password");
        }
    }
}