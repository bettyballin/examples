import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@interface CurrentUser {}

public class Temp2025 {
    public static void main(String[] args) {
        System.out.println("Annotation @CurrentUser is defined and the program runs successfully.");
    }
}