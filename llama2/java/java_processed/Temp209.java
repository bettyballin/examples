import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Temp209 {

    public static void main(String[] args) {
        SecurityContextHolder.setContext(new SecurityContextHolder());
        Temp209 instance = new Temp209();
        instance.someMethod(1, new User(2, "ROLE_USER"));
    }

    @PreAuthorize("!#authenticatingUser.id == #id and hasRole('ROLE_ADMIN')")
    public void someMethod(int id, User authenticatingUser) {
        // Method implementation
        System.out.println("Method executed");
    }
}

class User {
    public int id;
    public String role;

    public User(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}