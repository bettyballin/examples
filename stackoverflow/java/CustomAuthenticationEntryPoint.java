import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(CustomAuthenticationEntryPoint.class);
    private static final String MESSAGE_AUTHENTICATION_FAILED = "Authentication failed";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public CustomAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException exception)
            throws IOException {
        log.warn(MESSAGE_AUTHENTICATION_FAILED);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        super.commence(request, responseWrapper, exception);

        String responseStr = new String(responseWrapper.getContentAsByteArray(), responseWrapper.getCharacterEncoding());
        NewErrorResponse newErrorResponse = errorResponseWithDetail(responseStr);

        response.setStatus(responseWrapper.getStatus());
        response.setContentType(responseWrapper.getContentType());
        response.getWriter().write(this.objectMapper.writeValueAsString(newErrorResponse));
        response.getWriter().flush();
    }

    private NewErrorResponse errorResponseWithDetail(String responseStr) {
        // Your logic to create a new error response
        return new NewErrorResponse();
    }

    public static class NewErrorResponse {
        // Your error response structure
    }
}