public AccessDeniedException(String msg) {
        super(msg);
    }
    // Additional constructors or methods if needed
}

class NotOwnerException extends AccessDeniedException {
    public NotOwnerException(String msg) {
        super(msg);
    }
    // Additional constructors or methods if needed
}

class AccountSuspendedException extends AccessDeniedException {
    public AccountSuspendedException(String msg) {
        super(msg);
    }
    // Additional constructors or methods if needed
}

class User {
    // Hypothetical User class implementation
}

public class ObjectManager {

    public void deleteObject(Long objectId, User user) throws NotOwnerException, AccountSuspendedException {
        // Hypothetical implementation of the deleteObject method
        // Check if user is allowed to delete the object
        if (!userCanDelete(objectId, user)) {
            throw new NotOwnerException("User does not own the object");
        }
        // Check if user account is suspended
        if (isUserSuspended(user)) {
            throw new AccountSuspendedException("User account is suspended");
        }
        // Proceed with object deletion
        // ...
    }

    private boolean userCanDelete(Long objectId, User user) {
        // Hypothetical check
        return true;
    }

    private boolean isUserSuspended(User user) {
        // Hypothetical check
        return false;
    }
}