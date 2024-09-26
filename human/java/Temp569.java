import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Temp569 {
    public static void main(String[] args) {
        // Example usage of CustomSecurityAnnotation
        Temp569 temp = new Temp569();
        temp.someMethod();
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CustomSecurityAnnotation {
        String value();
    }

    @CustomSecurityAnnotation("someData")
    public void someMethod() {
        System.out.println("Method with custom security annotation executed.");
    }
}