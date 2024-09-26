import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {
        String exitMsg = request.getParameter("exitMsg");
        if (StringUtils.hasText(exitMsg)) {
            // do something with the custom parameter here
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }

    public CustomAuthenticationSuccessHandler() {
        super();
    }

    public CustomAuthenticationSuccessHandler(String targetUrlParameter) {
        super(targetUrlParameter);
    }
}