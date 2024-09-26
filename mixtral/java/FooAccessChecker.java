import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Service
public class FooAccessChecker {
    public boolean hasFooAccess(User user, String fooId) {
        // Implement your logic here to check if the given User can access the resource with ID 'fooId'

        return true;  // or false
    }
}

@Service
public class FooService {

    @Autowired
    private FooAccessChecker fooAccessChecker;

    public Foos getFoos(User user, String fooId) {
        if (!fooAccessChecker.hasFooAccess(user, fooId))
            throw new AccessDeniedException("You don't have access to this resource");

        // Fetch and return the 'foos'
        return new Foos(); // Placeholder for actual fetching logic
    }
}

@RestController
public class MyResource {

    @Autowired
    private FooService fooService;

    @GetMapping("/foo/{id}")
    public Foos getFoos(@AuthenticationPrincipal User user, @PathVariable String id) {
        return fooService.getFoos(user, id);
    }
}

// Assuming you have these placeholder classes for User and Foos
class User {
    // User properties and methods
}

class Foos {
    // Foos properties and methods
}