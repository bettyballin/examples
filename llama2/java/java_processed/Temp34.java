import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Dummy @Secured annotation definition for compilation purpose
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Secured {
    String value();
}

public class Temp34 {
    @Secured("admin")
    public void adminMethod() {
        // This method is only accessible for users with the "admin" authority
        System.out.println("adminMethod called");
    }

    @Secured("user")
    public void userMethod() {
        // This method is only accessible for users with the "user" authority
        System.out.println("userMethod called");
    }

    public static void main(String[] args) {
        Temp34 temp = new Temp34();
        temp.adminMethod();
        temp.userMethod();
    }
}