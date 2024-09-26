import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class Temp1966 {

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("authentication.principal.getId() == #userId")
    public User updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        // Implement the logic to update and return the user here
        return updatedUser;
    }

    public static void main(String[] args) {
        // Spring Boot applications are typically started with SpringApplication.run
        System.out.println("This is a Spring Boot application and should be run with SpringApplication.run");
    }
}

class User {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}