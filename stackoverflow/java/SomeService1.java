import org.springframework.security.access.prepost.PreAuthorize;

public class SomeService1 {

    @PreAuthorize("hasPermission(#entity, 'ADMINISTRATION')")
    public SomeEntity update(SomeEntity entity) {
        // ... method implementation
        return entity;
    }
    
    // Assuming SomeEntity is a valid class
    public class SomeEntity {
        // ... class members and methods
    }
}