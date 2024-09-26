import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@ControllerAdvice
public class RestAuthenticationEntryPoint {

    @ExceptionHandler(value = { MyAccessDeniedException.class })
    public void commence(HttpServletRequest request, HttpServletResponse response, MyAccessDeniedException ex) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ex.getRequestModel());
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write(json);
        response.flushBuffer();
    }
    
    // ... Rest of the class implementation ...
}