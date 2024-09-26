import org.springframework.security.access.annotation.Secured;

public class Temp322 {
    public static void main(String[] args) {
        // Example usage of the SecuredAdmin annotation
    }
}

@Secured({"ROLE_ADMIN"})
@interface SecuredAdmin {
    String[] value() default {};
}