import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Temp912 {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Secure {
        String[] roles();
    }

    @Secure(roles = {"admin", "moderator"})
    public static void testMethod() {
        System.out.println("This method is secured for admin and moderator roles.");
    }

    public static void main(String[] args) {
        testMethod();
    }
}