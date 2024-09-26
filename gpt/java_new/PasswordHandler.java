import java.util.Arrays;

public class PasswordHandler {
    public void handlePassword(Request request) {
        char[] password = request.getPassword(); // Assume this method gives you the password as a char array.
        try {
            String passwordHash = hashPassword(password);
            // Store passwordHash in the database.
        } finally {
            Arrays.fill(password, '0'); // Overwrite the password.
        }
    }

    private String hashPassword(char[] password) {
        // Implement password hashing logic
        return new String(password); // Placeholder for actual hashing
    }
}

class Request {
    public char[] getPassword() {
        // Method stub for getting the password
        return new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
    }
}