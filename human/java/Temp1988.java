import java.util.Arrays;

public class Temp1988 {
    private static final String DEFAULT_ADMIN_NAME = "admin";
    private static final String DEFAULT_ADMIN_PASSWORD = "password";
    private static final Roles[] roles = { Roles.USER, Roles.ADMIN };
    private static PasswordEncoder passwordEncoder = new PasswordEncoder();
    private static Users users = new Users();

    public static void main(String[] args) {
        try (AsInternalUser __ = new AsInternalUser()) {
            if (!users.exists(DEFAULT_ADMIN_NAME)) {
                users.save(new User(DEFAULT_ADMIN_NAME, passwordEncoder.encode(DEFAULT_ADMIN_PASSWORD), Arrays.asList(Roles.values())));
            }
        }
    }

    static class AsInternalUser implements AutoCloseable {
        @Override
        public void close() {
            // Clean up resources here
        }
    }

    static class PasswordEncoder {
        public String encode(String password) {
            // Simple encoding for demonstration
            return "encoded_" + password;
        }
    }

    static class Users {
        public boolean exists(String username) {
            // Check if user exists
            return false; // For demonstration purposes
        }

        public void save(User user) {
            // Save user
            System.out.println("User saved: " + user);
        }
    }

    static class User {
        private String username;
        private String password;
        private java.util.List<Roles> roles;

        public User(String username, String password, java.util.List<Roles> roles) {
            this.username = username;
            this.password = password;
            this.roles = roles;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", roles=" + roles +
                    '}';
        }
    }

    enum Roles {
        USER,
        ADMIN
    }
}