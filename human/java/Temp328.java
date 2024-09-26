import java.lang.annotation.*;

public class Temp328 {
    public static void main(String[] args) {
        System.out.println("Annotation defined!");
    }

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface ActiveUser {}
}