public class UserStatusException extends RuntimeException {
    public UserStatusException(String message) {
        super(message);
    }
}

public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            throw new UserStatusException("User status is not valid.");
        } catch (UserStatusException e) {
            System.out.println(e.getMessage());
        }

        try {
            throw new UsernameNotFoundException("Username not found.");
        } catch (UsernameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}