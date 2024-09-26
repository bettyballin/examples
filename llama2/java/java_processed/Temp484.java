import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Temp484 {
    public static void main(String[] args) {
        // Example usage of the annotation can go here
    }

    @Target({ ElementType.METHOD, ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UserCanSeeRestricted {
        // Placeholder for the PreAuthorize annotation condition
        String value() default "hasAuthority(@readRole())";
    }
}