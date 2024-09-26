import javax.naming.AuthenticationException;

public class DatabaseConnectionAuthenticationFailureException extends AuthenticationException {
    public DatabaseConnectionAuthenticationFailureException() {
        super();
    }

    public DatabaseConnectionAuthenticationFailureException(String msg) {
        super(msg);
    }
    
    public static void main(String[] args) {
        try {
            throw new DatabaseConnectionAuthenticationFailureException("Failed to authenticate database connection.");
        } catch (DatabaseConnectionAuthenticationFailureException e) {
            e.printStackTrace();
        }
    }
}