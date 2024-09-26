import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GRSAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        String code = request.getParameter("code");
        String failureUrl = "/login";
        if (code != null && !code.trim().isEmpty()) {
            failureUrl = failureUrl + "?code=" + code;
        }
        getRedirectStrategy().sendRedirect(request, response, failureUrl);
    }
}