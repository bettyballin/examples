import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        if (accessDeniedException instanceof NotOwnerException) {
            // set appropriate status and message for not owner exception
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().write("You can't delete the object because you are not the owner");
        } else if (accessDeniedException instanceof AccountSuspendedException) {
            // set appropriate status and message for account suspended exception
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().write("You can't create new objects because your account has been suspended");
        } else {
            // handle other access denied exceptions
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().write("Access Denied");
        }
    }
}

// Custom exception classes
class NotOwnerException extends AccessDeniedException {
    public NotOwnerException(String msg) {
        super(msg);
    }
}

class AccountSuspendedException extends AccessDeniedException {
    public AccountSuspendedException(String msg) {
        super(msg);
    }
}