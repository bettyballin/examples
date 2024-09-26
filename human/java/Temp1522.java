import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Temp1522 {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IpRestricted {
    }

    public static void main(String[] args) {
        // Example usage of the IpRestricted annotation
        @IpRestricted
        class ExampleClass {
        }

        System.out.println("Annotation defined and example class created.");
    }
}