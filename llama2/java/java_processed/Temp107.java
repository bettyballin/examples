public class Temp107 {
    public static void main(String[] args) {
        // Example usage of AuthenticationExceptionHandler
        AuthenticationExceptionHandler handler = new AuthenticationExceptionHandler() {
            @Override
            public void handle(AuthenticationException e) {
                System.out.println("Handling exception: " + e.getMessage());
            }
        };

        // Simulate an authentication exception
        try {
            throw new AuthenticationException("Invalid credentials");
        } catch (AuthenticationException e) {
            handler.handle(e);
        }
    }

    public interface AuthenticationExceptionHandler {
        void handle(AuthenticationException e);
    }

    // Mock AuthenticationException class to simulate an exception
    public static class AuthenticationException extends Exception {
        public AuthenticationException(String message) {
            super(message);
        }
    }
}