import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Temp1070 {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface CustomSecurityAnnotation {
    }

    public static void main(String[] args) {
        // Example usage of the annotation
        class Test {
            @CustomSecurityAnnotation
            public void securedMethod() {
                System.out.println("This is a secured method.");
            }
        }

        // Running the test
        Test test = new Test();
        test.securedMethod();
    }
}