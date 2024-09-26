import org.springframework.security.access.prepost.PreAuthorize;

public class SomeService {

    @PreAuthorize("isAuthenticated()")
    public void someMethod() {
        // method implementation
    }
}