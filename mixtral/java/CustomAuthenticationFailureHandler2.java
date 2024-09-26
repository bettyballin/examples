import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.core.AuthenticationException;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String code = request.getParameter("code");

        if (StringUtils.hasText(code)) {
            setDefaultFailureUrl("/login?error&code=" + code);
        } else {
            // Handle the case when 'code' parameter is not present
            super.onAuthenticationFailure(request, response, exception);
            return;
        }

        super.onAuthenticationFailure(request, response, exception);
    }
}