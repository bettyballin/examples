import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Define the Secured annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Secured {
    String role();
}

public class Temp204 {

    public static void main(String[] args) throws Exception {
        Temp204 temp = new Temp204();
        temp.myMethod();
    }

    @Secured(role = "USER")
    public void myMethod() {
        // ...
        System.out.println("Method executed with USER role.");
    }
}