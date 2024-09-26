import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// Define the Secured annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Secured {
    String[] value();
}

// Define a class for custom authorities constants
public class CustomAuthoritiesConstants {
    public static final String SUPERVISED = "ROLE_SUPERVISED";
}

// Use the Secured annotation on the GreatResource class
@Secured({CustomAuthoritiesConstants.SUPERVISED})
public class GreatResource {
    // Constructor or methods can be added here
    public static void main(String[] args) {
        System.out.println("GreatResource secured with: " + CustomAuthoritiesConstants.SUPERVISED);
    }
}