import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import java.io.IOException;

public class AuthenticationHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final String HASH_URL = "hashURL";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        String hashValue = request.getParameter(HASH_URL);
        if (hashValue != null && !hashValue.isEmpty()) {
            setDefaultTargetUrl("/home/" + hashValue);
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}