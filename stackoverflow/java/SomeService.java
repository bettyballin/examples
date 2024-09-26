import org.springframework.security.access.prepost.PostAuthorize;

public class SomeService {

    @PostAuthorize("hasRole('ROLE_ADMIN') or returnObject.hasDriverWithId(principal.id)")
    public SomeObject someMethod() {
        // method implementation
        return new SomeObject();
    }
}

class SomeObject {
    public boolean hasDriverWithId(String id) {
        // implementation details
        return true;
    }
}