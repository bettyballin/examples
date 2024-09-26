public class AuthenticationException extends Exception {
    public static final int USER_NOT_CONFIRMED = 1;
    public static final int DISABLED = 2;
    public static final int BAD_CREDENTIALS = 3;

    private int code;

    public AuthenticationException(int code) {
        super();
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static void main(String[] args) {
        try {
            throw new AuthenticationException(USER_NOT_CONFIRMED);
        } catch (AuthenticationException e) {
            System.out.println("Caught AuthenticationException with code: " + e.getCode());
        }
    }
}