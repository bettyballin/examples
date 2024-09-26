import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.RedirectStrategy;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Temp1254 {
    public static void main(String[] args) {
        AuthenticationFailureHandler handler = customAuthenticationFailureHandler();
        // You can add code here to test/use the handler if needed.
    }

    public static AuthenticationFailureHandler customAuthenticationFailureHandler() {
        ExceptionMappingAuthenticationFailureHandler exceptionMappingAuthenticationFailureHandler =
                new ExceptionMappingAuthenticationFailureHandler();
        Map<Object, Object> map = new HashMap<>();
        map.put(
                "org.springframework.security.authentication.CredentialsExpiredException",
                "/resetPassword.html"
        );

        exceptionMappingAuthenticationFailureHandler.setExceptionMappings(map);

        exceptionMappingAuthenticationFailureHandler.setRedirectStrategy(
                new RedirectStrategy() {
                    @Override
                    public void sendRedirect(
                            HttpServletRequest request, HttpServletResponse response, String url
                    ) throws IOException {
                        response.sendRedirect(request.getContextPath() + url);
                    }
                }
        );

        return exceptionMappingAuthenticationFailureHandler;
    }
}