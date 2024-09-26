import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class Temp2415 {

    public static void main(String[] args) {
        System.setProperty("java.security.auth.login.config", "jaas.conf");

        try {
            LoginContext lc = new LoginContext("Temp2415", new MyCallbackHandler());
            lc.login();
            System.out.println("Authentication succeeded!");
        } catch (LoginException e) {
            System.err.println("Authentication failed: " + e.getMessage());
        }
    }

    private static class MyCallbackHandler implements CallbackHandler {
        public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
            for (Callback callback : callbacks) {
                if (callback instanceof NameCallback) {
                    NameCallback nc = (NameCallback) callback;
                    nc.setName("principal");
                } else if (callback instanceof PasswordCallback) {
                    PasswordCallback pc = (PasswordCallback) callback;
                    pc.setPassword("password".toCharArray());
                } else {
                    throw new UnsupportedCallbackException(callback);
                }
            }
        }
    }
}


`jaas.conf` file:

Temp2415 {
  com.sun.security.auth.module.Krb5LoginModule required
  useKeyTab=true
  storeKey=true
  keyTab="path/to/keytab"
  principal="principal@REALM";
};