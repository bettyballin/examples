import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

public class Temp2799 {
    public static void main(String[] args) {
        // Example usage of the annotation
    }

    @Target({ ElementType.METHOD, ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @PreAuthorize("hasAnyAuthority(#root.getThis().getProps().getWriteRole())")
    public @interface UserCanEditRestricted { }
}