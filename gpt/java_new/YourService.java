import org.springframework.security.access.prepost.PreAuthorize;

public class YourService {

    @PreAuthorize("#thing.getOwner().getUsername() == authentication.principal.username")
    public void manipulateThing(Thing thing) {
        // Your code here
    }
}

class Thing {
    private User owner;
    // Assume getters and setters are here

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}

class User {
    private String username;
    // Assume getters and setters are here

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}