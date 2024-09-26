public class SecurityHelper {
    public static void setupSecurityContext(String username, String password, String... groups) {
        // Your implementation here
    }

    public static void main(String[] args) {
        setupSecurityContext("user", "password", "g1", "g2");
    }
}