public class CustomForbiddenException extends RuntimeException {
    public CustomForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public static void main(String[] args) {
        try {
            throw new CustomForbiddenException("Custom forbidden error", new Exception("Cause of the error"));
        } catch (CustomForbiddenException e) {
            e.printStackTrace();
        }
    }
}