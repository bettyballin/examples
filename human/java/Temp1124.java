import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.web.context.request.NativeWebRequest;

public class Temp1124 {

    private RememberMeServices myRememberMeServices;

    public static void main(String[] args) {
        // You can test the signIn method here
    }

    public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
        // load the user based on the account id
        // For example, let's assume user is loaded and authentication is created
        Authentication authentication = null; // replace with actual authentication logic

        // set remember-me cookie
        try {
            myRememberMeServices.onLoginSuccess(
                (HttpServletRequest) request.getNativeRequest(),
                (HttpServletResponse) request.getNativeResponse(),
                authentication);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // forward to the original URL
        return extractOriginalUrl(request);
    }

    public String extractOriginalUrl(NativeWebRequest request) {
        // Simulate extracting the original URL
        return "http://example.com/original";
    }

    // Dummy Connection class to make the code compile
    static class Connection<T> {
    }
}