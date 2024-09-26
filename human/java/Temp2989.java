import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Temp2989 {
    public static void main(String[] args) {
        // Your application logic here
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Documented
    public @interface AuthenticationPrincipal {
        String expression();
        boolean errorOnInvalidType() default false;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Documented
    @AuthenticationPrincipal(expression = "@fetchUser.apply(#this)", errorOnInvalidType=true)
    public @interface CurrentUser {}
}