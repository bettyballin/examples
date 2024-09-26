public class CustomSecurityException extends RuntimeException {
    private final int errorCode;

    public CustomSecurityException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    // Getter for the error code
    public int getErrorCode() {
        return errorCode;
    }

    public static void main(String[] args) {
        try {
            throw new CustomSecurityException(404, "Resource not found");
        } catch (CustomSecurityException e) {
            System.out.println("Caught exception with error code: " + e.getErrorCode() + " and message: " + e.getMessage());
        }
    }
}