import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.NativeWebRequest;

public class SignInService {

    private MyRememberMeServices myRememberMeServices;

    // Assume MyRememberMeServices is defined elsewhere and has the onLoginSuccess method
    // Assume extractOriginalUrl is defined elsewhere and accepts NativeWebRequest as a parameter

    @Override
    public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
        // load the user based on the account id
        // Assume we load the user and create an authentication object here

        // set remember-me cookie
        myRememberMeServices.onLoginSuccess(
            (HttpServletRequest) request.getNativeRequest(),
            (HttpServletResponse) request.getNativeResponse(),
            authentication); // Assuming 'authentication' is defined after user is loaded

        // forward to the original URL
        return extractOriginalUrl(request);
    }

    // Setter for MyRememberMeServices, assuming it's injected or set elsewhere
    public void setMyRememberMeServices(MyRememberMeServices myRememberMeServices) {
        this.myRememberMeServices = myRememberMeServices;
    }
}