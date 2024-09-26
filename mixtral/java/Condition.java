import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("@allowedForSystemUsersCondition.verify(authentication)")
public @interface AllowedForSystemUsers {
    String[] roles();

    Class<? extends Throwable> onDenied() default AccessDeniedByRoleException.class;

    public static class Condition {
        private String[] roles;

        public Condition(String[] roles) {
            this.roles = roles;
        }

        public void verify(Authentication authentication) throws AccessDeniedException {
            if (!authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority).anyMatch(role -> Arrays.asList(roles).contains(role))) {
                throw new AccessDeniedByRoleException("Access denied for roles: " + Arrays.toString(roles));
            }
        }
    }
}

class AccessDeniedByRoleException extends AccessDeniedException {
    public AccessDeniedByRoleException(String msg) {
        super(msg);
    }
}