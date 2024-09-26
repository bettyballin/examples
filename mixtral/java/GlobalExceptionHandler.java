import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({CustomSecurityException.class})
    public ErrorDetails handleForbiddenExceptions(HttpServletRequest request, CustomSecurityException ex) {
        return new ErrorDetails("Access Denied", "You do not have permission to access this resource.", HttpStatus.FORBIDDEN);
    }

}

class CustomSecurityException extends RuntimeException {
    public CustomSecurityException(String message) {
        super(message);
    }
}

class ErrorDetails {
    private String title;
    private String detail;
    private HttpStatus status;

    public ErrorDetails(String title, String detail, HttpStatus status) {
        this.title = title;
        this.detail = detail;
        this.status = status;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}