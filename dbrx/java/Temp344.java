import java.util.Collection;
import java.util.List;

class User {
    private String username;
    private String password;
    private List<String> roles;
    private String id;
    private String name;
    private String email;

    // Constructor
    public User(String username, String password, List<String> roles, String id, String name, String email) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class CustomUserDetails {
    private String username;
    private String password;
    private Collection<String> authorities;
    private String id;
    private String name;
    private String email;

    public CustomUserDetails(String username, String password, Collection<String> authorities, String id, String name, String email) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and other methods can be added here
}

public class Temp344 {
    public static void main(String[] args) {
        User user = new User("username", "password", List.of("ROLE_USER"), "1", "John Doe", "john@example.com");

        CustomUserDetails customUserDetails = new CustomUserDetails(
            user.getUsername(),
            user.getPassword(),
            getAuthorities(user.getRoles()),
            user.getId(),
            user.getName(),
            user.getEmail()
        );
        
        // You can now use customUserDetails object as needed
    }

    private static Collection<String> getAuthorities(List<String> roles) {
        // Logic to convert roles to authorities
        return List.copyOf(roles);
    }
}