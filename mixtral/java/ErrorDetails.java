public class ErrorDetails {
    private final String title;
    private final String message;
    private final int statusCode;

    public ErrorDetails(String title, String message, HttpStatus httpStatus) {
        this.title = title;
        this.message = message;
        this.statusCode = httpStatus.value();
    }

    // Getters for the fields
    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public static void main(String[] args) {
        // Example usage of ErrorDetails class
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorDetails error = new ErrorDetails("Bad Request", "The request was invalid.", httpStatus);
        System.out.println("Title: " + error.getTitle());
        System.out.println("Message: " + error.getMessage());
        System.out.println("Status Code: " + error.getStatusCode());
    }
}

// HttpStatus enum definition for the example
enum HttpStatus {
    BAD_REQUEST(400),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    private final int value;

    HttpStatus(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}