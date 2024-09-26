import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Secure {
    String[] roles() default {};
}

public class Temp1331 {
    public static void main(String[] args) {
        // Example usage of the Secure annotation
        new Temp1331().exampleMethod();
    }
    
    @Secure(roles = {"ADMIN", "USER"})
    public void exampleMethod() {
        System.out.println("Example method executed.");
    }
}