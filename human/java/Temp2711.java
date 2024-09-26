import java.util.List;
import java.util.ArrayList;

class Role {
    // Assume this class has necessary fields and methods
}

class User {
    private List<Role> roles;

    public User() {
        this.roles = new ArrayList<>();
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }
}

class UserRepository {
    public User findOne(int userId) {
        // For simplicity, let's return a new User object with some roles
        User user = new User();
        user.addRole(new Role());
        user.addRole(new Role());
        return user;
    }
}

public class Temp2711 {
    public static void main(String[] args) {
        int userId = 1; // Assume some userId
        UserRepository userRepository = new UserRepository();
        User user = userRepository.findOne(userId);
        List<Role> roles = user.getRoles();

        // Just to confirm roles are fetched, printing the size of roles list
        System.out.println("Number of roles: " + roles.size());
    }
}