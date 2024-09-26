public class UserUnauthorizedException extends RuntimeException {
    public UserUnauthorizedException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        try {
            throw new UserUnauthorizedException("User is not authorized.");
        } catch (UserUnauthorizedException e) {
            System.out.println(e.getMessage());
        }
    }
}