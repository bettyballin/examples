import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp3503 {
    public static void main(String[] args) {
        SpringApplication.run(Temp3503.class, args);
    }
}

@RestController
class MyResourceController {
    @PostAuthorize("returnObject.username == authentication.name")
    @GetMapping("/resource/{id}")
    public MyResource getResource(@PathVariable String id) {
        // Simulate a resource lookup
        MyResource myResource = new MyResource();
        myResource.setId(id);
        myResource.setUsername("user1"); // Assume this is retrieved from some data source
        return myResource;
    }
}

class MyResource {
    private String id;
    private String username;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}