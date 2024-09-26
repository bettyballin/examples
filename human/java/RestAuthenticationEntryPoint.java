import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@ControllerAdvice
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }

    @ExceptionHandler(value = { MyAccessDeniedException.class })
    public void handleAccessDeniedException(HttpServletRequest request, HttpServletResponse response, MyAccessDeniedException ex) throws IOException {
        String json = new ObjectMapper().writeValueAsString(ex.getRequestModel());
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write(json);
        response.flushBuffer();
    }
}

class MyAccessDeniedException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Object requestModel;

    public MyAccessDeniedException(Object requestModel) {
        this.requestModel = requestModel;
    }

    public Object getRequestModel() {
        return requestModel;
    }
}