import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Temp901 {
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Role {
        String value();
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println("Role annotation example");
    }
}