public class CustomAccessDeniedException extends RuntimeException {
    private boolean allowedForSystemUsers;

    public CustomAccessDeniedException(String message, boolean allowedForSystemUsers) {
        super(message);
        this.allowedForSystemUsers = allowedForSystemUsers;
    }

    public boolean isAllowedForSystemUsers() {
        return allowedForSystemUsers;
    }
}

public class Temp414 {
    public static void main(String[] args) {
        throw new CustomAccessDeniedException("User not authorized", true);
    }
}