public class AccessDeniedByRoleException extends RuntimeException {
    public AccessDeniedByRoleException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        try {
            throw new AccessDeniedByRoleException("Access denied due to insufficient role!");
        } catch (AccessDeniedByRoleException e) {
            System.out.println(e.getMessage());
        }
    }
}