import org.springframework.security.access.prepost.PreAuthorize;

public class Temp188 {

    public static void main(String[] args) {
        // Test the doSomethingWithThing method here if needed
    }

    @PreAuthorize("hasRole('ROLE_USER') and #thing.user == principal")
    public void doSomethingWithThing(User user, Thing thing) {
        // ...
    }
}

class User {
    // Add necessary fields and methods
}

class Thing {
    User user;
    // Add necessary fields and methods
}