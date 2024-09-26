import java.util.Arrays;

// Assuming the necessary imports and context such as:
// - `AsInternalUser` class implements AutoCloseable
// - `users` is an instance of a class with `exists` and `save` methods
// - `DEFAULT_ADMIN_NAME` and `DEFAULT_ADMIN_PASSWORD` are defined constants
// - `passwordEncoder.encode` method exists and `passwordEncoder` is defined
// - `User` class constructor matches the used signature
// - `Roles` is an enum with values method

public class Main63 {
    private static final String DEFAULT_ADMIN_NAME = "admin";
    private static final String DEFAULT_ADMIN_PASSWORD = "adminPass";
    private static final PasswordEncoder passwordEncoder = new PasswordEncoder();
    private static final Users users = new Users();

    public static void main(String[] args) {
        try (AsInternalUser __ = new AsInternalUser()) {
            if (!users.exists(DEFAULT_ADMIN_NAME)) {
                users.save(new User(DEFAULT_ADMIN_NAME, passwordEncoder.encode(DEFAULT_ADMIN_PASSWORD), Arrays.asList(Roles.values())));
            }
        }
    }

    // Placeholder classes to make the snippet compile
    static class AsInternalUser implements AutoCloseable {
        @Override
        public void close() { }
    }

    static class User {
        public User(String name, String encodedPassword, Iterable<Roles> roles) { }
    }

    enum Roles {
        ROLE_USER, ROLE_ADMIN
    }

    static class Users {
        public boolean exists(String name) { return false; }
        public void save(User user) { }
    }

    static class PasswordEncoder {
        public String encode(String password) { return password; }
    }
}