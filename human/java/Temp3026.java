import java.lang.annotation.*;

public class Temp3026 {
    public static void main(String[] args) {
        // Example usage of the @CurrentUser annotation
        System.out.println("Annotation defined and main method executed.");
    }

    @Target({ElementType.PARAMETER, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface CurrentUser {
        // Define any attributes for the annotation here if needed.
    }
}