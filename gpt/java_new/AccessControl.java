// Enum for roles
public enum Role {
    USER,
    ADMIN
}

// Custom annotation to define which roles are allowed
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AllowedRoles {
    Role[] value();
}

// Class with methods that have role-based access
public class AccessControl {

    @AllowedRoles({Role.ADMIN})
    public void restrictedMethod() {
        // Method logic
    }

    @AllowedRoles({Role.USER, Role.ADMIN})
    public void openMethod() {
        // Method logic
    }
}