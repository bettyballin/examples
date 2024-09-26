import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, User> users = new HashMap<>();
        users.put("jsmith", new User("password", Arrays.asList("role1")));
        users.put("ajones", new User("anotherPassword", Arrays.asList("role1", "role2")));

        Map<String, List<String>> roles = new HashMap<>();
        roles.put("role1", Arrays.asList("perm1", "perm2", "permN"));
        roles.put("role2", Arrays.asList("permA", "permB", "permZ"));

        // Example usage
        User user = users.get("jsmith");
        if (user != null) {
            System.out.println("User: jsmith");
            System.out.println("Password: " + user.getPassword());
            System.out.println("Roles: " + user.getRoles());
            for (String role : user.getRoles()) {
                System.out.println("Permissions for " + role + ": " + roles.get(role));
            }
        }
    }
}

class User {
    private String password;
    private List<String> roles;

    public User(String password, List<String> roles) {
        this.password = password;
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getRoles() {
        return roles;
    }
}