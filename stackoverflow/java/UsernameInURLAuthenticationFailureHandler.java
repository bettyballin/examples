import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UsernameInURLAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private String urlPrefix;
    private String formUsernameKey;

    public UsernameInURLAuthenticationFailureHandler(String urlPrefix, String formUsernameKey) {
        this.urlPrefix = urlPrefix;
        this.formUsernameKey = formUsernameKey;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        String username = request.getParameter(formUsernameKey);
        String redirectUrl = urlPrefix + username;
        getRedirectStrategy().sendRedirect(request, response, redirectUrl);
    }
}