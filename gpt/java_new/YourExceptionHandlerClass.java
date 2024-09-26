import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class YourExceptionHandlerClass {

    @ExceptionHandler(AccessDeniedException.class)
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exc) throws IOException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String jsonPayload = "{\"message\" : \"%s\", \"timestamp\" : \"%s\" }";
        String formattedJsonPayload = String.format(jsonPayload, exc.getMessage(), Calendar.getInstance().getTime());
        response.getWriter().write(formattedJsonPayload);
    }
}