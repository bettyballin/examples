import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.access.prepost.PreAuthorize;

public class SomeClass1 {

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void someMethod() {
        // method implementation
    }
}

@WithMockUser(roles="ROLE_ADMIN")
class SomeTestClass {
    // test methods
}