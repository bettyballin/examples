import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Temp202 {
    public static void main(String[] args) {
        // Example usage of the @Secured annotation
        try {
            securedMethod();
        } catch (AccessDeniedException e) {
            System.out.println("Access Denied: " + e.getMessage());
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Secured {
        String role() default "USER";
        boolean denyAll() default false;
    }

    @Secured(role = "ADMIN", denyAll = true)
    public static void securedMethod() throws AccessDeniedException {
        throw new AccessDeniedException("You do not have the required role to access this method.");
    }

    public static class AccessDeniedException extends Exception {
        public AccessDeniedException(String message) {
            super(message);
        }
    }
}