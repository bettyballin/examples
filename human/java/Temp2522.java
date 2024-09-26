import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RequireUserOwnership {
    boolean allowAdmin() default false;
}

// Simulate @Service annotation
@interface Service {
}

// Simulate ActionResult class
class ActionResult {
    // Implementation can be added here
}

// Simulate BookDTO class
class BookDTO {
    // Implementation can be added here
}

@Service
interface BookService {
    @RequireUserOwnership(allowAdmin = false)
    ActionResult saveToDatabase(final BookDTO book);
}

public class Temp2522 {
    public static void main(String[] args) {
        // Testing implementation can be added here
    }
}