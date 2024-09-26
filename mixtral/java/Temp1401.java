import org.springframework.http.HttpStatus;

public class Temp1401 {
    public static void main(String[] args) {
        throw new CustomSecurityException(HttpStatus.FORBIDDEN.value(), "You do not have permission to access this resource.");
    }
}

class CustomSecurityException extends RuntimeException {
    private int statusCode;

    public CustomSecurityException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}