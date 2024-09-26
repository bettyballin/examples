import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class Temp2016 {

    private AuthenticationManager authenticationManager;
    private AuthenticationFailureHandler failureHandler;

    public static void main(String[] args) {
        Temp2016 temp = new Temp2016();
        // You can create instances of AuthenticationManager and AuthenticationFailureHandler here
        // and call the setAuthenticationManager method for testing.
    }

    @Autowired
    @Qualifier("authenticationManager")
    public void setAuthenticationManager(AuthenticationManager authenticationManager, AuthenticationFailureHandler failureHandler) {
        this.authenticationManager = authenticationManager;
        this.failureHandler = failureHandler;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler failureHandler) {
        this.failureHandler = failureHandler;
    }
}