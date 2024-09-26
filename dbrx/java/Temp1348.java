import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@interface CurrentUser {}

public class Temp1348 {
    public static void main(String[] args) {
        System.out.println("Annotation @CurrentUser is defined.");
    }
}