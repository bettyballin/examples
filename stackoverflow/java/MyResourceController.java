import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyResourceController {

    @PostAuthorize("returnObject.username == authentication.name")
    @GetMapping("/resource/{id}")
    public MyResource getResource(@PathVariable String id) {
        // look up
        MyResource myResource = findResourceById(id);
        return myResource;
    }

    private MyResource findResourceById(String id) {
        // Implementation for finding the resource
        return new MyResource(); // Placeholder for actual resource retrieval logic
    }
}

class MyResource {
    public String username;

    // Other fields and methods
}