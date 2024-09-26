import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Temp573 {
    public static void main(String[] args) {
        // Your main method implementation here
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RequiresAuthentication {
        public String[] roles();
    }
}