import java.nio.file.AccessDeniedException;

public class NotOwnerException extends AccessDeniedException {
    public NotOwnerException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        try {
            throw new NotOwnerException("User is not the owner.");
        } catch (NotOwnerException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class AccountSuspendedException extends AccessDeniedException {
    public AccountSuspendedException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        try {
            throw new AccountSuspendedException("Account has been suspended.");
        } catch (AccountSuspendedException e) {
            System.out.println(e.getMessage());
        }
    }
}