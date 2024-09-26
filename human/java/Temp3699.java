import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Temp3699 extends BasicAuthenticationEntryPoint {

    private static final String MESSAGE_AUTHENTICATION_FAILED = "Authentication failed.";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        // The main method is not needed for this class's functionality, it's here for the sake of completeness.
    }

    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException exception)
            throws IOException {
        System.out.println(MESSAGE_AUTHENTICATION_FAILED);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        super.commence(request, responseWrapper, exception);

        String responseStr = new String(responseWrapper.getContentAsByteArray(), responseWrapper.getCharacterEncoding());

        NewErrorResponse newErrorResponse = errorResponseWithDetail(responseStr);

        response.setStatus(responseWrapper.getStatus());
        response.setContentType(responseWrapper.getContentType());
        response.getWriter().write(this.objectMapper.writeValueAsString(newErrorResponse));
    }

    private NewErrorResponse errorResponseWithDetail(String responseStr) {
        // Implement this method to create a NewErrorResponse object from the responseStr
        // For demonstration, returning a dummy NewErrorResponse object
        return new NewErrorResponse("Error", responseStr);
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("Temp3699");
        super.afterPropertiesSet();
    }

    // Dummy NewErrorResponse class for demonstration purposes
    static class NewErrorResponse {
        private String error;
        private String detail;

        public NewErrorResponse(String error, String detail) {
            this.error = error;
            this.detail = detail;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
}