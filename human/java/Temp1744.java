import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Temp1744 {
    public static void main(String[] args) {
        // Example usage of @RolesAllowed annotation
        @RolesAllowed({"ADMIN", "USER"})
        class ExampleClass {
        }
    }

    @Inherited
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RolesAllowed {
        String[] value();
    }
}