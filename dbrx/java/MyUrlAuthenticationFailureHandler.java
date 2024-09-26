import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyUrlAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private static final String SPRING_SECURITY_LAST_EXCEPTION_KEY = "SPRING_SECURITY_LAST_EXCEPTION";

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Map<String, Object> errorAttributes = new HashMap<>();
        errorAttributes.put("error", getErrorMessage(request, SPRING_SECURITY_LAST_EXCEPTION_KEY));

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonError = objectMapper.writeValueAsString(errorAttributes);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(jsonError);
    }

    @SuppressWarnings("unchecked")
    private String getErrorMessage(HttpServletRequest request, String key) {
        AuthenticationException exception = (AuthenticationException) request.getSession().getAttribute(key);

        if (exception instanceof DisabledException) {
            return "BOD/EOD";
        }
        return "another";
    }
}