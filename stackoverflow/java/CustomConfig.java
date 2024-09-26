import org.springframework.context.annotation.Bean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomConfig {

    @Bean
    public AuthenticationFailureHandler customAuthenticationFailureHandler() {
        ExceptionMappingAuthenticationFailureHandler exceptionMappingAuthenticationFailureHandler =
                new ExceptionMappingAuthenticationFailureHandler();
        Map<String, String> map = new HashMap<>();
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

    // Assuming RedirectStrategy is an interface that needs to be imported or declared
    public interface RedirectStrategy {
        void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException;
    }
}