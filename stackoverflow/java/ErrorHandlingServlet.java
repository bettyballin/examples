import javax.servlet.http.HttpServletRequest;

public class ErrorHandlingServlet {
    private HttpServletRequest request;

    public ErrorHandlingServlet(HttpServletRequest request) {
        this.request = request;
    }

    public String handleError() {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        String exceptionMessage = getExceptionMessage(throwable, statusCode);
        return exceptionMessage;
    }

    private String getExceptionMessage(Throwable throwable, Integer statusCode) {
        if (throwable != null) {
            return throwable.getMessage();
        } else if (statusCode != null) {
            return "Error with status code: " + statusCode;
        } else {
            return "Unknown error";
        }
    }
}