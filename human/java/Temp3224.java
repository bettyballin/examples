import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

public class Temp3224 {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface AdditionalCertificateValidations {
        String[] allowedCommonNames() default {};
        String[] notAllowedCommonNames() default {};
    }

    public static void main(String[] args) {
        // Example usage of the annotation
    }
}