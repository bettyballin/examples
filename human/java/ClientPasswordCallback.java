package dvstest;

import java.io.IOException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.wss4j.common.ext.WSPasswordCallback;

public class ClientPasswordCallback implements CallbackHandler {

    @Override
    public void handle(Callback[] callbacks) throws IOException,
            UnsupportedCallbackException {

        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];

        // set the password for our message.
        pc.setPassword("mypass");
    }

    public static void main(String[] args) {
        // Example usage
        ClientPasswordCallback callbackHandler = new ClientPasswordCallback();
        WSPasswordCallback passwordCallback = new WSPasswordCallback("user", 0);
        Callback[] callbacks = new Callback[] { passwordCallback };

        try {
            callbackHandler.handle(callbacks);
            System.out.println("Password set to: " + passwordCallback.getPassword());
        } catch (IOException | UnsupportedCallbackException e) {
            e.printStackTrace();
        }
    }
}