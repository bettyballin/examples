import org.springframework.security.access.prepost.PreAuthorize;

public class SomeClass1 {

    @PreAuthorize("hasPermission(#entity, 'ADMINISTRATION') or hasRole('ROLE_ADMIN')")
    public void someMethod(Object entity) {
        // method body
    }
}