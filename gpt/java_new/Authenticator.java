import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.security.auth.callback.CallbackHandler;

import org.jboss.security.auth.callback.UsernamePasswordHandler;

public class Authenticator {

    public void login(String username, char[] password, String otp) throws LoginException {
        CallbackHandler handler = new UsernamePasswordHandler(username, password, otp.toCharArray());
        LoginContext lc = new LoginContext("MyOtpSecurityDomain", handler);
        lc.login();
    }
    
    // Other class members and methods
}