import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.authentication.CredentialsExpiredException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    public CustomAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION") instanceof CredentialsExpiredException) {
            return "/changePassword";
        } else {
            return super.determineTargetUrl(request, response);
        }
    }
}


Note: To run this code, you need to have Spring Security dependencies in your project.