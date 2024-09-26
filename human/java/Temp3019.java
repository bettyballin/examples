import java.util.HashSet;
import java.util.Set;

public class Temp3019 {

    private static final int MAX_ATTEMPTS = 3;
    private static MembersDao membersDao = new MembersDao(); // Assuming MembersDao is defined elsewhere

    public static void main(String[] args) {
        // Example usage
        UserDetails user = loadUserAndCheckLogin("example@example.com", "password123");
        if (user != null) {
            System.out.println("Login successful for user: " + user.getUsername());
        } else {
            System.out.println("Login failed.");
        }
    }

    public static UserDetails loadUserAndCheckLogin(String email, String enteredPassword) {
        Members members = membersDao.findByEmail(email);
        if (members == null) {
            // Create Error Message for User
            return null;
        }
        if (members.getAttempts() > MAX_ATTEMPTS) {
            // Create Error Message for User
            return null;
        }
        if (members.getPassword().equals(enteredPassword)) {
            Set<GrantedAuthority> authorities = new HashSet<>();
            Role role = members.getRoles();
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
            members.setAttempts(0);
            membersDao.save(members);
            return new User(members.getEmail(), members.getPassword(), authorities);
        } else {
            int attempts = members.getAttempts();
            members.setAttempts(++attempts);
            membersDao.save(members);
            // Create Error Message for User
            return null;
        }
    }
}

class UserDetails {
    private String username;
    private String password;
    private Set<GrantedAuthority> authorities;

    public UserDetails(String username, String password, Set<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    // Other getter methods...
}

class User extends UserDetails {
    public User(String username, String password, Set<GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}

interface GrantedAuthority {
    String getAuthority();
}

class SimpleGrantedAuthority implements GrantedAuthority {
    private String role;

    public SimpleGrantedAuthority(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}

class Members {
    private String email;
    private String password;
    private int attempts;
    private Role roles;

    // Getters and setters...

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public Role getRoles() {
        return roles;
    }
}

class Role {
    private String role;

    public String getRole() {
        return role;
    }
}

class MembersDao {
    // Mock implementation for demonstration purposes
    public Members findByEmail(String email) {
        // Simulate finding a member by email
        return new Members(); // Replace with actual implementation
    }

    public void save(Members members) {
        // Simulate saving a member
    }
}